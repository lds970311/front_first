// Author : evan lee
// Time ： 2022-05-20  0:10
// FILENAME : CacheClient.java
// STATEMENT: 

package com.hmdp.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class CacheClient {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static final ExecutorService CACHE_REBUILD_EXECUTOR = Executors.newFixedThreadPool(10);

    /**
     * 设置有ttl的key
     *
     * @param key
     * @param value
     * @param time
     * @param unit
     */
    public void set(String key, Object value, Long time, TimeUnit unit) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, JSONUtil.toJsonStr(value), time, unit);
    }

    /**
     * 设置逻辑过期的key
     *
     * @param key
     * @param value
     * @param time
     * @param unit
     */
    public void setWithLogicalExpire(String key, Object value, Long time, TimeUnit unit) {
        //设置逻辑过期
        RedisData redisData = new RedisData();
        redisData.setData(value);
        redisData.setExpireTime(LocalDateTime.now().plusSeconds(unit.toSeconds(time)));
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, JSONUtil.toJsonStr(redisData));
    }

    /**
     * 查询缓存, 解决缓存穿透
     *
     * @param keyPrefix
     * @param id
     * @param type
     * @param function
     * @param time
     * @param unit
     * @param <T>
     * @param <R>
     * @return
     */
    public <T, R> T queryCache(String keyPrefix, R id, Class<T> type, Function<R, T> function, Long time, TimeUnit unit) {
        String key = keyPrefix + id;
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        String json = valueOperations.get(key);
        if (StrUtil.isNotBlank(json)) {
            return JSONUtil.toBean(json, type);
        }
        //不存在
        if (json != null) {
            //json == ""
            return null;
        }
        //不存在, 根据id查询数据库
        T t = function.apply(id);
        if (t == null) {
            valueOperations.set(key, "", time, unit);
            return null;
        }
        //存在
        valueOperations.set(key, JSONUtil.toJsonStr(t), time, unit);
        return t;
    }

    /**
     * 查询缓存, 使用逻辑过期解决缓存击穿问题
     *
     * @param keyPrefix
     * @param id
     * @param type
     * @param func
     * @param time
     * @param unit
     * @param <T>
     * @param <ID>
     * @return
     */
    public <T, ID> T queryWithLogicExpire(String keyPrefix,
                                          ID id,
                                          Class<T> type,
                                          Function<ID, T> func,
                                          Long time,
                                          TimeUnit unit) {
        String key = keyPrefix + id;
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        String json = valueOperations.get(key);
        if (StrUtil.isBlank(json)) {
            return null;
        }
        //命中缓存, 先把json反序列化为对象
        RedisData redisData = JSONUtil.toBean(json, RedisData.class);
        T t = JSONUtil.toBean((JSONObject) redisData.getData(), type);
        LocalDateTime expireTime = redisData.getExpireTime();
        if (expireTime.isAfter(LocalDateTime.now())) {
            //key未过期
            return t;
        }
        //key已经过期: 缓存重建, 获取互斥锁,启动新线程, 查询数据库
        String lockKey = RedisConstants.LOCK_SHOP_KEY + id;
        boolean isLock = RedisMutexUtils.tryLock(stringRedisTemplate, lockKey);
        if (isLock) {
            CACHE_REBUILD_EXECUTOR.submit(() -> {
                try {
                    T result = func.apply(id);
                    this.setWithLogicalExpire(key, result, time, unit);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    //释放锁
                    RedisMutexUtils.unLock(stringRedisTemplate, lockKey);
                }
            });
        }
        return t;
    }

    /**
     * 使用互斥锁解决缓存击穿
     *
     * @param keyPrefix
     * @param id
     * @param type
     * @param dbFallback
     * @param time
     * @param unit
     * @param <R>
     * @param <ID>
     * @return
     */
    public <R, ID> R queryWithMutex(
            String keyPrefix, ID id, Class<R> type, Function<ID, R> dbFallback, Long time, TimeUnit unit) {
        String key = keyPrefix + id;
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        String json = valueOperations.get(key);
        if (StrUtil.isNotBlank(json)) {
            return JSONUtil.toBean(json, type);
        }
        if (json != null) {
            return null;
        }
        String lockKey = RedisConstants.LOCK_SHOP_KEY + id;
        R r = null;
        //获取互斥锁
        try {
            boolean isLock = RedisMutexUtils.tryLock(stringRedisTemplate, lockKey);
            if (!isLock) {
                //没获取到锁
                Thread.sleep(100);
                return queryWithMutex(keyPrefix, id, type, dbFallback, time, unit);
            }
            //查询数据库
            r = dbFallback.apply(id);
            if (r == null) {
                // 将空值写入redis
                stringRedisTemplate.opsForValue().set(key, "", RedisConstants.CACHE_NULL_TTL, TimeUnit.MINUTES);
                // 返回错误信息
                return null;
            }
            // 6.存在，写入redis
            this.set(key, r, time, unit);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //释放锁
            RedisMutexUtils.unLock(stringRedisTemplate, lockKey);
        }
        return r;
    }
}
