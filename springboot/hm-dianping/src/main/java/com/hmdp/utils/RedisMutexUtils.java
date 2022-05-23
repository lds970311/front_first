// Author : evan lee
// Time ： 2022-05-19  20:16
// FILENAME : RedisMutexUtils.java
// STATEMENT: 

package com.hmdp.utils;

import cn.hutool.core.util.BooleanUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

public class RedisMutexUtils {
    private RedisMutexUtils() {
    }

    public static boolean tryLock(StringRedisTemplate stringRedisTemplate, String key) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        Boolean flag = valueOperations.setIfAbsent(key, "1", 15, TimeUnit.SECONDS);
        return BooleanUtil.isTrue(flag);
    }

    public static void unLock(StringRedisTemplate stringRedisTemplate, String key) {
        stringRedisTemplate.delete(key);
    }
}
