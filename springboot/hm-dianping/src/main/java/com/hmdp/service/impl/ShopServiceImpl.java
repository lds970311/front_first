package com.hmdp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.Shop;
import com.hmdp.mapper.ShopMapper;
import com.hmdp.service.IShopService;
import com.hmdp.utils.CacheClient;
import com.hmdp.utils.RedisConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private CacheClient cacheClient;

    @Override
    public Result queryShopById(Long id) {
        //从redis查询商户缓存`
        /*ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        String shop = valueOperations.get(RedisConstants.CACHE_SHOP_KEY + id);
        //判断商户是否存在
        if (StrUtil.isNotBlank(shop)) {
            Shop bean = JSONUtil.toBean(shop, Shop.class);
            return Result.ok(bean);
        }
        //shop是"", 解决缓存穿透
        if (shop != null) {
            //返回错误信息
            return Result.fail("店铺不存在!");
        }
        Shop shop1 = null;
        //缓存未命中, 尝试获取互斥锁,解决缓存击穿!
        try {
            boolean isLock = RedisMutexUtils.tryLock(stringRedisTemplate, RedisConstants.LOCK_SHOP_KEY);
            //获取失败, 休眠则重试
            if (!isLock) {
                Thread.sleep(100);
                queryShopById(id);
            }
            //获取成功,则查询数据库, 更新缓存, 释放锁
            shop1 = this.getById(id);
            if (shop1 == null) {
                //将null值写入redis,避免缓存穿透
                valueOperations.set(RedisConstants.CACHE_SHOP_KEY + id, "", RedisConstants.CACHE_NULL_TTL, TimeUnit.MINUTES);
                return Result.fail("店铺不存在!");
            }
            //存在,写入redis
            valueOperations.set(RedisConstants.CACHE_SHOP_KEY + id, JSONUtil.toJsonStr(shop1), 30L, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisMutexUtils.unLock(stringRedisTemplate, RedisConstants.LOCK_SHOP_KEY);
        }

        return Result.ok(shop1);*/
        Shop shop = null;
        shop = cacheClient.queryCache(RedisConstants.CACHE_SHOP_KEY, id, Shop.class,
                this::getById, RedisConstants.CACHE_SHOP_TTL, TimeUnit.MINUTES);
        if (shop == null) {
            return Result.fail("店铺不存在！");
        }
        Shop shop1 = cacheClient.queryWithMutex(RedisConstants.CACHE_SHOP_KEY, id, Shop.class,
                this::getById, RedisConstants.CACHE_SHOP_TTL, TimeUnit.MINUTES);
        if (shop1 == null) {
            return Result.fail("店铺不存在！");
        }
        return Result.ok(shop1);
    }

    @Override
    @Transactional
    public Result update(Shop shop) {
        Long shopId = shop.getId();
        if (shopId == null) {
            return Result.fail("店铺id不能为空!");
        }
        //更新数据库
        updateById(shop);
        //删除缓存
        stringRedisTemplate.delete(RedisConstants.CACHE_SHOP_KEY + shop.getId());
        return Result.ok("更新成功!");
    }
}
