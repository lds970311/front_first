package com.hmdp.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.ShopType;
import com.hmdp.mapper.ShopTypeMapper;
import com.hmdp.service.IShopTypeService;
import com.hmdp.utils.RedisConstants;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryType() {
        ListOperations<String, String> stringListOperations = stringRedisTemplate.opsForList();
        List<String> strings = stringListOperations.range(RedisConstants.SHOP_TYPE_LIST, 0, -1);

        if (strings != null && strings.size() != 0) {
            List<ShopType> shopTypes = JSONUtil.toList(strings.toString(), ShopType.class);
            return Result.ok(shopTypes);
        }
        List<ShopType> typeList = this
                .query().
                orderByAsc("sort")
                .list();
        //将数据存入redis
        for (ShopType shopType : typeList) {
            stringListOperations.rightPush(RedisConstants.SHOP_TYPE_LIST, JSONUtil.toJsonStr(shopType));
        }

        return Result.ok(typeList);
    }
}
