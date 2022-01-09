// Author : evan lee
// Time ： 2022-01-09  1:01
// FILENAME : Server.java
// STATEMENT: 

package com.codewolf.java.threads.clientchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    /** 定义一个集合存放所有在线的socket */
    public static Map<Socket, String> onLineSockets = new HashMap<>();
    private static final int port = 17788;

    public static void main(String[] args) {
        try {
            /** 注册端口   */
            ServerSocket serverSocket = new ServerSocket(port);

            /** 循环一直等待所有可能的客户端连接 */
            //创建线程池进行连接
            ExecutorService pool = new ThreadPoolExecutor(10, 20, 100, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(10),
                    new ThreadPoolExecutor.AbortPolicy());
            while (true) {
                Socket socket = serverSocket.accept();
                /** 把客户端的socket管道单独配置一个线程来处理 */
                pool.execute(new ServerReader(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ServerReader implements Runnable {

    private Socket socket;
    private final String SPILIT = "003197♣♣㏘♣④④♣";

    public ServerReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(socket.getInputStream());
            /** 循环一直等待客户端的消息 */
            while (true) {
                /** 读取当前的消息类型 ：登录,群发,私聊 , @消息 */
                int flag = dis.readInt();
                if (flag == 1) {
                    /** 先将当前登录的客户端socket存到在线人数的socket集合中   */
                    String name = dis.readUTF();
                    System.out.println(name + "---->" + socket.getRemoteSocketAddress());
                    Server.onLineSockets.put(socket, name);
                }
                writeMsg(flag, dis);
            }
        } catch (Exception e) {
            System.out.println("--有人下线了--");
            // 从在线人数中将当前socket移出去
            Server.onLineSockets.remove(socket);
            try {
                // 从新更新在线人数并发给所有客户端
                writeMsg(1, dis);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }

    private void writeMsg(int flag, DataInputStream dis) throws Exception {
//		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        // 定义一个变量存放最终的消息形式
        String msg = null;
        if (flag == 1) {
            /** 读取所有在线人数发给所有客户端去更新自己的在线人数列表 */
            /** onlineNames = [徐磊,zhangsan,李刚]*/
            StringBuilder rs = new StringBuilder();
            Collection<String> onlineNames = Server.onLineSockets.values();
            // 判断是否存在在线人数
            if (onlineNames.size() > 0) {
                for (String name : onlineNames) {
                    rs.append(name).append(SPILIT);
                }
                // 徐磊003197♣♣㏘♣④④♣zhangsan003197♣♣㏘♣④④♣李刚003197♣♣㏘♣④④♣
                // 去掉最后的一个分隔符
                msg = rs.substring(0, rs.lastIndexOf(SPILIT));

                /** 将消息发送给所有的客户端 */
                sendMsgToAll(flag, msg);
            }
        } else if (flag == 2 || flag == 3) {
            // 读到消息  群发的 或者 @消息
            String newMsg = dis.readUTF(); // 消息
            // 得到发件人
            String sendName = Server.onLineSockets.get(socket);

            // 李刚 时间
            //    内容--
            StringBuilder msgFinal = new StringBuilder();
            // 时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");
            if (flag == 2) {
                msgFinal.append(sendName).append("  ").append(sdf.format(System.currentTimeMillis())).append("\r\n");
                msgFinal.append("    ").append(newMsg).append("\r\n");
                sendMsgToAll(flag, msgFinal.toString());
            } else {
                msgFinal.append(sendName).append("  ").append(sdf.format(System.currentTimeMillis())).append("对您私发\r\n");
                msgFinal.append("    ").append(newMsg).append("\r\n");
                // 私发
                // 得到给谁私发
                String destName = dis.readUTF();
                sendMsgToOne(destName, msgFinal.toString());
            }
        }
    }

    /**
     * @param destName 对谁私发
     * @param msg      发的消息内容
     * @throws Exception
     */
    private void sendMsgToOne(String destName, String msg) throws Exception {
        // 拿到所有的在线socket管道 给这些管道写出消息
        Set<Socket> allOnLineSockets = Server.onLineSockets.keySet();
        for (Socket sk : allOnLineSockets) {
            // 得到当前需要私发的socket
            // 只对这个名字对应的socket私发消息
            if (Server.onLineSockets.get(sk).trim().equals(destName)) {
                DataOutputStream dos = new DataOutputStream(sk.getOutputStream());
                dos.writeInt(2); // 消息类型
                dos.writeUTF(msg);
                dos.flush();
            }
        }

    }

    private void sendMsgToAll(int flag, String msg) throws Exception {
        // 拿到所有的在线socket管道 给这些管道写出消息
        Set<Socket> allOnLineSockets = Server.onLineSockets.keySet();
        for (Socket sk : allOnLineSockets) {
            DataOutputStream dos = new DataOutputStream(sk.getOutputStream());
            dos.writeInt(flag); // 消息类型
            dos.writeUTF(msg);
            dos.flush();
        }
    }
}
