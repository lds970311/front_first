// Author : evan lee
// Time ： 2022-05-20  0:10
// FILENAME : CacheClient.java
// STATEMENT: 

package com.hmdp.service.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class CacheClient {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

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
}
