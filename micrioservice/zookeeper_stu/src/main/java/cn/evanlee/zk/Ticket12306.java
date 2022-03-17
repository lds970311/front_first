// Author : evan lee
// Time ： 2022-03-17  3:08
// FILENAME : Ticket12306.java
// STATEMENT: 

package cn.evanlee.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryOneTime;

import java.util.concurrent.TimeUnit;

public class Ticket12306 implements Runnable {
    //票数
    private int ticketNum = 20;

    //分布式可重入排它锁
    private InterProcessMutex lock;

    public Ticket12306() {
        CuratorFramework client = CuratorFrameworkFactory.
                builder()
                .sessionTimeoutMs(2000)
                .connectionTimeoutMs(2000)
                .retryPolicy(new RetryOneTime(1000))
                .connectString("192.168.208.129:2181")
                .build();
        client.start();
        this.lock = new InterProcessMutex(client, "/lock");
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.acquire(2, TimeUnit.SECONDS); //获取锁
                if (ticketNum > 0) {
                    System.out.println(Thread.currentThread().getName() + ": 票数" + ticketNum);
                    Thread.sleep(200);
                    ticketNum--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    lock.release(); //释放锁
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
