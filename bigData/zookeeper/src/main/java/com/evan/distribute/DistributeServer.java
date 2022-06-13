// Author : evan lee
// Time ： 2022-06-12  23:16
// FILENAME : DistributeServer.java
// STATEMENT: 

package com.evan.distribute;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class DistributeServer {
    private static String connectString = "hadoop149:2181,hadoop131:2181,hadoop132:2181";
    private static int sessionTimeout = 2000;
    private ZooKeeper zkClient = null;
    public static final String parentNode = "/servers";

    public void connectZooKeeper() {
        try {
            zkClient = new ZooKeeper(connectString, sessionTimeout, watchedEvent -> {
                System.out.println(watchedEvent.getType() + "===" + watchedEvent.getPath());
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void register(String hostName) {
        try {
            zkClient.create(parentNode + "/" + hostName, hostName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(hostName + "is online!");
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DistributeServer distributeServer = new DistributeServer();
        distributeServer.connectZooKeeper();
        distributeServer.register(args[0]);
        Thread.sleep(Long.MAX_VALUE);
    }
}
