// Author : evan lee
// Time ： 2022-07-26  18:35
// FILENAME : LiveLockTest.java
// STATEMENT: 

package cn.evan.lock;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.LiveLockTest")
public class LiveLockTest {
    static final Object lock = new Object();
    static volatile int count = 10;

    public static void main(String[] args) {
        new Thread(() -> {
            // 期望减到 0 退出循环
            while (count > 0) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count--;
                log.debug("count: {}", count);
            }
        }, "t1").start();

        new Thread(() -> {
            // 期望超过 20 退出循环
            while (count < 20) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
                log.debug("count: {}", count);
            }
        }, "t2").start();
    }
}
