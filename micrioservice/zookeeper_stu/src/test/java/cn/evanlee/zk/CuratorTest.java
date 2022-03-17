// Author : evan lee
// Time ： 2022-03-16  21:28
// FILENAME : CuratorTest.java
// STATEMENT: 

package cn.evanlee.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.*;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class CuratorTest {
    private static CuratorFramework client;


    /**
     * 建立连接
     */
    @Test
    public void testConnection() {
        //方式1
        /*
         *
         * @param connectString       连接字符串。zk server 地址和端口 "192.168.149.135:2181,192.168.149.136:2181"
         * @param sessionTimeoutMs    会话超时时间 单位ms
         * @param connectionTimeoutMs 连接超时时间 单位ms
         * @param retryPolicy         重试策略
         */
        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.208.129:2181", 2000, 2000, new RetryOneTime(2000));
        client.start(); //启动客户端
    }

    @Before
    public void testConnection2() {
        //建造者模式
        client = CuratorFrameworkFactory.builder()
                .connectString("192.168.208.129:2181")
                .sessionTimeoutMs(2000)
                .connectionTimeoutMs(2000)
                .retryPolicy(new RetryNTimes(2, 1000))
                .namespace("evan") //指定根节点
                .build();

        client.start();
    }

    @After
    public void closeClient() {
        Optional.ofNullable(client)
                .ifPresent(CuratorFramework::close);
    }

    //创建节点
    @Test
    public void createNode() throws Exception {
        CreateBuilder createBuilder = client.create();
        String s = createBuilder.forPath("/app_two", "haha".getBytes());
        System.out.println(s);
    }

    @Test
    public void createNode2() throws Exception {
        CreateBuilder createBuilder = client.create();
        //指定节点类型
        createBuilder.withMode(CreateMode.PERSISTENT);
        String s = createBuilder.forPath("/app_two", "haha".getBytes());
        System.out.println(s);
    }

    @Test
    public void createNode3() throws Exception {
        //创建多级
        CreateBuilder createBuilder = client.create();
        //指定节点类型
        createBuilder.withMode(CreateMode.PERSISTENT);
        String s = createBuilder
                .creatingParentContainersIfNeeded()
                .forPath("/app_four/p1", "haha4".getBytes());
        System.out.println(s);
    }

    @Test
    public void getNode() throws Exception {
        //查询节点数据
        GetDataBuilder getDataBuilder = client.getData();
        String res = new String(getDataBuilder.forPath("/app_four/p1"));
        System.out.println(res);
    }

    @Test
    public void getNode2() throws Exception {
        //查询子节点数据
        GetChildrenBuilder getChildrenBuilder = client.getChildren();
        List<String> strings = getChildrenBuilder.forPath("/");
        for (String s : strings) {
            System.out.println(s);
        }
    }

    @Test
    public void getNode3() {
        //查询节点状态
        Stat stat = new Stat();
        client.getData().storingStatIn(stat);
        System.out.println(stat);
    }

    /**
     * 修改数据
     * 1. 基本修改数据：setData().forPath()
     * 2. 根据版本修改: setData().withVersion().forPath()
     * * version 是通过查询出来的。目的就是为了让其他客户端或者线程不干扰我。
     *
     * @throws Exception
     */
    @Test
    public void setNodeData() throws Exception {
        //修改数据
        SetDataBuilder setDataBuilder = client.setData();
        setDataBuilder.forPath("/app_one", "time".getBytes());
    }

    @Test
    public void setForVersion() throws Exception {
        //设置版本
        Stat stat = new Stat();
        client.getData().storingStatIn(stat);
        int version = stat.getVersion();
        client.setData()
                .withVersion(version)
                .forPath("/app_one", "hello".getBytes());
    }

    /**
     * 删除节点： delete deleteall
     * 1. 删除单个节点:delete().forPath("/app1");
     * 2. 删除带有子节点的节点:delete().deletingChildrenIfNeeded().forPath("/app1");
     * 3. 必须成功的删除:为了防止网络抖动。本质就是重试。  client.delete().guaranteed().forPath("/app2");
     * 4. 回调：inBackground
     *
     * @throws Exception
     */


    @Test
    public void testDelete() throws Exception {
        // 1. 删除单个节点
        client.delete().forPath("/app_one");
    }

    @Test
    public void testDelete2() throws Exception {
        //2. 删除带有子节点的节点
        client.delete().deletingChildrenIfNeeded().forPath("/app_four");
    }

    @Test
    public void testDelete3() throws Exception {
        //3. 必须成功的删除
        client.delete().guaranteed().forPath("/app_two");
    }

    @Test
    public void testDelete4() throws Exception {
        //4. 回调
        client.delete().guaranteed().inBackground(new BackgroundCallback() {

            @Override
            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println("我被删除了~");
                System.out.println(event);
            }
        }).forPath("/app_one");
    }

}
