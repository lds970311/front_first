// Author : evan lee
// Time ： 2022-06-12  23:27
// FILENAME : DistributeClient.java
// STATEMENT: 

package com.evan.distribute;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistributeClient {
    private static String connectString = "hadoop149:2181,hadoop131:2181,hadoop132:2181";
    private static int sessionTimeout = 2000;
    private ZooKeeper zkClient = null;
    public static String parentNode = "/servers";

    public void getConnection() {
        try {
            zkClient = new ZooKeeper(connectString, sessionTimeout, watchedEvent -> {
                System.out.println(watchedEvent.getType() + "===" + watchedEvent.getPath());
                this.getServerList();
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DistributeClient distributeClient = new DistributeClient();
        distributeClient.getConnection();
        distributeClient.getServerList();
        distributeClient.doBussiness();
    }

    private void doBussiness() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void getServerList() {
        try {
            List<String> children = zkClient.getChildren(parentNode, true);
            List<String> nodeList = new ArrayList<>();
            for (String child : children) {
                byte[] data = zkClient.getData(parentNode + "/" + child, false, null);
                nodeList.add(new String(data));
            }
            System.out.println(nodeList);
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
