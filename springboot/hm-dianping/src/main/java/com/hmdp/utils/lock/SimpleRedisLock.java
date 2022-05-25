// Author : evan lee
// Time ： 2022-05-24  20:18
// FILENAME : SimpleRedisLock.java
// STATEMENT: 

package com.hmdp.utils.lock;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.BooleanUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleRedisLock implements ILock {

    private static final String KEY_PREFIX = "lock:";
    private String lockName;
    private StringRedisTemplate stringRedisTemplate;
    private static final String ID_PREFIX = UUID.randomUUID().toString(true) + "_";
    private static final DefaultRedisScript<Long> unlockScript;

    static {
        unlockScript = new DefaultRedisScript<>();
        unlockScript.setLocation(new ClassPathResource("scripts/distributionLock.lua"));
        unlockScript.setResultType(Long.class);
    }

    public SimpleRedisLock(String lockName, StringRedisTemplate stringRedisTemplate) {
        this.lockName = lockName;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean tryLock(long timeoutSeconds) {
        String threadId = ID_PREFIX + Thread.currentThread().getId();
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        Boolean setIfAbsent = valueOperations.setIfAbsent(KEY_PREFIX + lockName, threadId, timeoutSeconds, TimeUnit.SECONDS);
        return BooleanUtil.isTrue(setIfAbsent);
    }

    @Override
    public void unlock() {
        //获取线程标识
        String threadId = ID_PREFIX + Thread.currentThread().getId();
        String lockKey = KEY_PREFIX + lockName;
        //判断redis锁的表示是否一致
       /* ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        String s = valueOperations.get(KEY_PREFIX + lockName);
        if (Objects.equals(s, threadId)) {
            //一致
            stringRedisTemplate.delete(KEY_PREFIX + lockName);
        }
        //不一致*/
        //执行lua脚本
        stringRedisTemplate.execute(unlockScript, List.of(lockKey), threadId);
    }
}
