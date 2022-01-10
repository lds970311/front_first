// Author : evan lee
// Time ： 2022-01-09  12:38
// FILENAME : BSDemo.java
// STATEMENT: 

package com.codewolf.java.net;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

class BSServer implements Runnable {
    private final Socket socket;

    public BSServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //创建打印流
        try {
            PrintStream out = new PrintStream(this.socket.getOutputStream());
            out.println("HTTP/1.1 200 OK"); // 协议类型和版本 响应成功的消息！
            out.println("Content-Type:text/html;charset=UTF-8"); // 响应的数据类型：文本/网页

            out.println(); // 必须发送一个空行

            // 才可以响应数据回去给浏览器
            renderHTML(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void renderHTML(PrintStream out) {
        //创建缓冲流
        try {
            BufferedReader reader = new BufferedReader(new FileReader("F:\\Java\\front_first\\java_base\\src\\com\\codewolf\\java\\net\\indexPage.html"));
            String content = null;
            while ((content = reader.readLine()) != null) {
                out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class BSDemo {
    @SneakyThrows
    public static void main(String[] args) {
        ServerSocket serverSocket = new ServerSocket(8901);
        System.out.println("server start on port 8901");
        while (true) {
            Socket accept = serverSocket.accept();
            new Thread(new BSServer(accept)).start();
        }
    }
}
