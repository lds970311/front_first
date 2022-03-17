// Author : evan lee
// Time ： 2022-03-16  23:36
// FILENAME : CuratorWatcherTest.java
// STATEMENT: 

package cn.evanlee.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.listen.Listenable;
import org.apache.curator.framework.listen.ListenerContainer;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.RetryNTimes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

@SuppressWarnings("all")
public class CuratorWatcherTest {
    private static CuratorFramework client;

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

    @Test
    public void testNodeCache() throws Exception {
        //创建NodeCache
        NodeCache nodeCache = new NodeCache(client, "/app_four");
        ListenerContainer<NodeCacheListener> listenerContainer = nodeCache.getListenable();
        listenerContainer.addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.print("note changed, now is:");
                //获取修改后的数据
                ChildData currentData = nodeCache.getCurrentData();
                String msg = new String(currentData.getData());
                System.out.println(msg);
            }
        });
        nodeCache.start(true); //开启监听.如果设置为true，则开启监听是，加载缓冲数据
        while (true) {
            Thread.sleep(1000);
        }
    }

    @Test
    public void testPathChildrenCache() throws Exception {
        // 1.创建监听对象
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/app_two", true);

        // 2. 绑定监听器
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                System.out.println("子节点变化了~");
                System.out.println(event);
                // 监听子节点的数据变更，并且拿到变更后的数据
                // 1.获取类型
                PathChildrenCacheEvent.Type type = event.getType();
                // 2.判断类型是否是update
                if (type.equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)) {
                    System.out.println("数据变了！！！");
                    byte[] data = event.getData().getData();
                    System.out.println(new String(data));

                }
            }
        });
        // 3. 开启
        pathChildrenCache.start();

        while (true) {
            Thread.sleep(1000);
        }
    }

    @Test
    public void testTreeCache() throws Exception {
        // 1.创建监听对象
        TreeCache treeCache = new TreeCache(client, "/app_four");
        Listenable<TreeCacheListener> listenable = treeCache.getListenable();
        listenable.addListener(new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                System.out.println("子节点变化了~");
                TreeCacheEvent.Type type = treeCacheEvent.getType();
                if (type.equals(TreeCacheEvent.Type.NODE_UPDATED)) {
                    System.out.println("子节点数据变更!");
                    byte[] data = treeCacheEvent.getData().getData();
                    System.out.println(new String(data));
                }
            }
        });
        treeCache.start();
        while (true) {
            Thread.sleep(2000);
        }
    }
}
