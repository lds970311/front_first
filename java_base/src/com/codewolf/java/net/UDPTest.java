// Author : evan lee
// Time ： 2022-01-08  21:08
// FILENAME : UDPTest.java
// STATEMENT: 

package com.codewolf.java.net;

import lombok.SneakyThrows;
import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPTest {
    @SneakyThrows
    public static void udpSender() {
        DatagramSocket sender = new DatagramSocket(); //发送端
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("输入发送的内容,exit退出");
            String content = sc.nextLine();
            if ("exit".equals(content)) {
                break;
            }
            byte[] buf = content.getBytes();
            //数据打包
            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 15488);
            sender.send(packet);
        }
        sender.close();
    }

    @Test
    @SneakyThrows
    public void udpReceiver() {
        DatagramSocket receiver = new DatagramSocket(15488);
        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, 1024);
            int length = packet.getLength();
            //等待接收数据
            receiver.receive(packet);
            String s = new String(buf, 0, length);
            if (s.equals("exit")) {
                break;
            }
            System.out.println("收到来自" + packet.getAddress() + ":" + packet.getPort() + "的消息: " + s);

        }

        receiver.close();
    }

    public static void main(String[] args) {
        udpSender();
    }
}
