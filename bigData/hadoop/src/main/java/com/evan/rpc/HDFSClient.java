// Author : evan lee
// Time ： 2022-06-11  19:56
// FILENAME : HDFSClient.java
// STATEMENT: 

package com.evan.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HDFSClient {
    public static void main(String[] args) throws IOException {
        RPCProtocol protocol = RPC.getProxy(
                RPCProtocol.class,
                RPCProtocol.versionID,
                new InetSocketAddress("localhost", 8888),
                new Configuration()
        );
        System.out.println("我是客户端");
        protocol.mkdirs("/input");
    }
}
