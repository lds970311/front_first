// Author : evan lee
// Time ： 2022-05-22  0:10
// FILENAME : RedisIDUtil.java
// STATEMENT: 

package com.hmdp.utils;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * redis全局唯一id生成器
 */
@Component
public class RedisIDUtil {
    private static final long BEGIN_TIMESTAMP = 1640995200L;
    private static final int COUNT_BITS = 32; //序列号位数

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public Long nextID(String keyPrefix) {
        //1.生成时间戳
        LocalDateTime now = LocalDateTime.now();
        long nowSecond = now.toEpochSecond(ZoneOffset.UTC);
        long timeStamp = nowSecond - BEGIN_TIMESTAMP;
        //2.生成序列号
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        //获取当前日期, 作为key
        String format = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        Long increment = valueOperations.increment("incr:" + keyPrefix + format);
        //3.拼接并返回
        return timeStamp << COUNT_BITS | increment;
    }
}
