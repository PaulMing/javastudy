/*
   基于TCP的通信：文件传送
   服务端
*/
package com.mi.net.tcp.picture;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        // 监听：其是阻塞式监听，会一直等待客户端连接
        Socket socket = serverSocket.accept();
        // 输入流
        InputStream is = socket.getInputStream();

        // 文件输出
        FileOutputStream fos = new FileOutputStream(new File("copy.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1) {
            fos.write(buffer,0,len);
        }

        // 通知客户端接收完成
        OutputStream os = socket.getOutputStream();
        os.write("接受完毕了，可以断开了".getBytes());

        // 关闭资源
        os.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
