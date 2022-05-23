package com.hmdp;

import com.hmdp.utils.RedisIDUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class HmDianPingApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisIDUtil redisIDUtil;

    private ExecutorService es = Executors.newFixedThreadPool(100);

    @SneakyThrows
    @Test
    void testA() {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                Long order = redisIDUtil.nextID("order");
                System.out.println(order);
                countDownLatch.countDown();
            }
        };
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            this.es.submit(task);
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("用时: " + (end - begin) + "ms");
    }

}
