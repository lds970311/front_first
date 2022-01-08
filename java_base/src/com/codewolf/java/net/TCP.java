// Author : evan lee
// Time ： 2022-01-08  22:24
// FILENAME : TCP.java
// STATEMENT: SOCKET编程

package com.codewolf.java.net;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TCP {
    @SneakyThrows
    public static void socket() {
        System.out.println("client start success!");
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8988); //客户
        OutputStream os = socket.getOutputStream();
        //把低级流-> 高级流
        PrintStream ps = new PrintStream(os);
        while (true) {
            System.out.println("输入发送的消息!");
            String ctx = scanner.nextLine();
            ps.println(ctx);
            ps.flush();
            if ("exit".equals(ctx)) break;
        }
        ps.close();
    }


    @Test
    @SneakyThrows
    public void serverSocket() {
        System.out.println("server start success!");
        ServerSocket serverSocket = new ServerSocket(8988);
        //创建线程池, 接收客户端请求
        ExecutorService pool = new ThreadPoolExecutor(10, 20, 100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy());
        do {
            pool.execute(() -> {
                Socket accept = null;
                try {
                    accept = serverSocket.accept();//上线
                    InputStream is = accept.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(inputStreamReader);
                    String content;
                    while ((content = br.readLine()) != null) {
                        System.out.println(content);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } while (true);
    }

    public static void main(String[] args) {
        socket();
    }
}
