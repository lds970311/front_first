// Author : evan lee
// Time ： 2022-06-12  21:07
// FILENAME : ZookeeperClient.java
// STATEMENT: 

package com.evan.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ZookeeperClient {
    private static String connectString = "hadoop149:2181,hadoop131:2181,hadoop132:2181";
    private static int sessionTimeout = 2000;
    private ZooKeeper zkClient = null;

    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(this.connectString, this.sessionTimeout, watchedEvent -> {
            // 收到事件通知后的回调函数（用户的业务逻辑）
            System.out.println(watchedEvent.getType() + "--" + watchedEvent.getPath());
            List<String> children = null;
            try {
                children = zkClient.getChildren("/", true);
            } catch (KeeperException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (String child : children) {
                System.out.println(child);
            }
        });
    }

    @Test
    public void createNode() throws InterruptedException, KeeperException {
        String s = zkClient.create("/lol/type", "tank".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(s);
    }

    @Test
    public void getChildren() throws InterruptedException, KeeperException {
        List<String> children = zkClient.getChildren("/", true);
        for (String child : children) {
            System.out.println(child);
        }
        //延时,不结束程序
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void exist() throws InterruptedException, KeeperException {
        Stat stat = zkClient.exists("/lol", false);
        System.out.println(stat == null ? "not exist" : "exist");
    }
}
