/*
   客户端
*/
package com.mi.net.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class ClientDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress serverIp = InetAddress.getByName("127.0.0.1");
        int port = 9999;

        Socket socket = null;
        OutputStream os = null;
        try {
            socket = new Socket(serverIp,port);
            os = socket.getOutputStream();
            os.write("".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源 -> 后开先关
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}