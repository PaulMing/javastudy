/*
   基于UDP的通信：
      发送包时并不用关注'接收方能否接收到'，直接发送即可
*/
package com.mi.net.udp;

import java.io.IOException;
import java.net.*;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建socket
        DatagramSocket socket = new DatagramSocket();

        // 创建包
        String msg = "测试数据";
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9000;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,localhost,port);

        // 发送包
        socket.send(packet);

        // 关闭资源
        socket.close();
    }
}