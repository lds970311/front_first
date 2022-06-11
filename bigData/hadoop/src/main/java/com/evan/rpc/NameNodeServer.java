// Author : evan lee
// Time ： 2022-06-11  19:53
// FILENAME : NameNodeServer.java
// STATEMENT: 

package com.evan.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

public class NameNodeServer implements RPCProtocol {

    @Override
    public void mkdirs(String path) {
        System.out.println("服务端，创建路径" + path);
    }

    public static void main(String[] args) throws IOException {
        RPC.Builder builder = new RPC.Builder(new Configuration());
        RPC.Server server = builder.setBindAddress("localhost")
                .setPort(8888)
                .setProtocol(RPCProtocol.class)
                .setInstance(new NameNodeServer())
                .build();

        System.out.println("服务器开始工作");
        server.start();
    }
}
