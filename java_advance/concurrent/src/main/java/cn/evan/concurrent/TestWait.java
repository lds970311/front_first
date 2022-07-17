// Author : evan lee
// Time ： 2022-07-17  20:36
// FILENAME : TestWait.java
// STATEMENT: 

package cn.evan.concurrent;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestWait")
public class TestWait {
    final static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (obj) {
                log.debug("执行....");
                try {
                    obj.wait(); // 让线程在obj上一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其它代码....");
            }
        }).start();
        new Thread(() -> {
            synchronized (obj) {
                log.debug("执行....");
                try {
                    obj.wait(); // 让线程在obj上一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其它代码....");
            }
        }).start();
        // 主线程两秒后执行
        Thread.sleep(2000);
        log.debug("唤醒 obj 上其它线程");
        synchronized (obj) {
            //obj.notify(); // 唤醒obj上一个线程
            obj.notifyAll(); // 唤醒obj上所有等待线程
        }
    }
}
