package com.hmdp.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.Shop;
import com.hmdp.mapper.ShopMapper;
import com.hmdp.service.IShopService;
import com.hmdp.utils.RedisConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryShopById(Long id) {
        //从redis查询商户缓存`
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        String shop = valueOperations.get(RedisConstants.CACHE_SHOP_KEY + id);
        //判断商户是否存在
        if (StrUtil.isNotBlank(shop)) {
            Shop bean = JSONUtil.toBean(shop, Shop.class);
            return Result.ok(bean);
        }
        if (shop != null) {
            //返回错误信息
            return Result.fail("店铺不存在!");
        }
        Shop shop1 = this.getById(id);
        if (shop1 == null) {
            //将null值写入redis,避免缓存穿透
            valueOperations.set(RedisConstants.CACHE_SHOP_KEY + id, "", RedisConstants.CACHE_NULL_TTL, TimeUnit.MINUTES);
            return Result.fail("店铺不存在!");
        }
        //存在,写入redis
        valueOperations.set(RedisConstants.CACHE_SHOP_KEY + id, JSONUtil.toJsonStr(shop1), 30L, TimeUnit.MINUTES);
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
