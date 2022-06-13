// Author : evan lee
// Time ： 2022-06-13  17:42
// FILENAME : DistributedLock.java
// STATEMENT: 

package com.evan.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DistributedLock {
    private static String connectString = "hadoop149:2181,hadoop131:2181,hadoop132:2181";
    private static int sessionTimeout = 2000;
    private ZooKeeper zkClient = null;
    private String rootNode = "locks";
    private String subNode = "seq-";
    // 当前 client 等待的子节点
    private String waitPath;
    //ZooKeeper 连接
    private CountDownLatch connectLatch = new CountDownLatch(1);
    //ZooKeeper 节点等待
    private CountDownLatch waitLatch = new CountDownLatch(1);
    // 当前 client 创建的子节点
    private String currentNode;

    public DistributedLock() throws IOException, InterruptedException, KeeperException {
        this.zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    // 连接建立时, 打开 latch, 唤醒 wait 在该 latch 上的线程
                    connectLatch.countDown();
                }
                // 发生了 waitPath 的删除事件
                if (watchedEvent.getType() == Event.EventType.NodeDeleted && watchedEvent.getPath().equals(waitPath)) {
                    waitLatch.countDown();
                }
            }
        });
        // 等待连接建立
        connectLatch.await();
        //获取根节点状态
        Stat stat = zkClient.exists("/" + rootNode, false);
        //如果根节点不存在，则创建根节点，根节点类型为永久节点
        if (stat == null) {
            System.out.println("根节点不存在");
            zkClient.create("/" + rootNode, new byte[0],
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
    }

    /**
     * 添加锁
     */
    public void zkLock() {
        //在根节点下创建临时顺序节点，返回值为创建的节点路径
        try {
            currentNode = zkClient.create("/" + rootNode + "/" + subNode, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            // wait 一小会, 让结果更清晰一些
            Thread.sleep(10);
            List<String> children = zkClient.getChildren("/" + rootNode, false);
            // 列表中只有一个子节点, 那肯定就是 currentNode , 说明client 获得锁
            if (children.size() == 1) {
                return;
            } else {
                //对根节点下的所有临时顺序节点进行从小到大排序
                Collections.sort(children);
                String thisNode = this.currentNode.substring(("/" + rootNode + "/").length());
                //获取当前节点的位置
                int index = children.indexOf(thisNode);
                if (index == -1) {
                    System.out.println("数据异常");
                } else if (index == 0) {
                    // index == 0, 说明 thisNode 在列表中最小, 当前client 获得锁
                    return;
                } else {
                    // 获得排名比 currentNode 前 1 位的节点
                    this.waitPath = "/" + rootNode + "/" + children.get(index - 1);
                    // 在 waitPath 上注册监听器, 当 waitPath 被删除时,zookeeper 会回调监听器的 process 方法
                    zkClient.getData(waitPath, true, new Stat());
                    //进入等待锁状态
                    waitLatch.await();
                    return;
                }
            }
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解锁
     */
    public void zkUnlock() {
        try {
            zkClient.delete(this.currentNode, -1);
        } catch (InterruptedException | KeeperException e) {
            throw new RuntimeException(e);
        }
    }
}
