package com.mi.net.picture;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9000);
        // 输出流
        OutputStream os = socket.getOutputStream();

        // 读取文件
        FileInputStream fis = new FileInputStream(new File("1.jpg"));
        // 输出文件
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1) {
            os.write(buffer,0,len);
        }

        // 关闭资源
        fis.close();
        os.close();
        socket.close();
    }
}