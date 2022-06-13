// Author : evan lee
// Time ： 2022-06-13  18:08
// FILENAME : CuratorLock.java
// STATEMENT: 

package com.evan.lock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorLock {
    private static String connectString = "hadoop149:2181,hadoop131:2181,hadoop132:2181";
    private static int sessionTimeout = 2000;
    // connection 超时时间
    private int connectionTimeout = 2000;
    private String rootNode = "/locks";

    // 分布式锁初始化
    public CuratorFramework getCuratorFramework() {
        //重试策略，初试时间 3 秒，重试 3 次
        RetryPolicy policy = new ExponentialBackoffRetry(3000, 3);
        //通过工厂创建 Curator
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .connectionTimeoutMs(connectionTimeout)
                .sessionTimeoutMs(sessionTimeout)
                .retryPolicy(policy)
                .build();
        //开启连接
        client.start();
        System.out.println("zookeeper 初始化完成...");
        return client;
    }

    public void test() {
        // 创建分布式锁 1
        final InterProcessLock lock1 = new InterProcessMutex(this.getCuratorFramework(), rootNode);
        // 创建分布式锁 2
        final InterProcessLock lock2 = new InterProcessMutex(this.getCuratorFramework(), rootNode);

        new Thread(() -> {
            // 获取锁对象
            try {
                lock1.acquire();
                System.out.println("线程 1 获取锁");
                // 测试锁重入
                lock1.acquire();
                System.out.println("线程 1 再次获取锁");
                Thread.sleep(5 * 1000);
                lock1.release();
                System.out.println("线程 1 释放锁");
                lock1.release();
                System.out.println("线程 1 再次释放锁");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                lock2.acquire();
                System.out.println("线程 2 获取锁");
                // 测试锁重入
                lock2.acquire();
                System.out.println("线程 2 再次获取锁");
                Thread.sleep(5 * 1000);
                lock2.release();
                System.out.println("线程 2 释放锁");
                lock2.release();
                System.out.println("线程 2 再次释放锁");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {

        CuratorLock curatorLock = new CuratorLock();
        curatorLock.test();
    }
}
