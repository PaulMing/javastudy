## 网络编程
> C/S架构，其没有很强的客户端、服务端区分，聚焦在各主机间的网络通信 -> JAVA提供接口化调用方式，屏蔽掉底层硬件相关，实际仅关注"IP、端口、协议"即可，IP确定主机地址[网络层]、端口确定进程[传输层]、协议仅关注传输层、网络层即可[传输层的TCP/UDP，网络层的IP，传输层往上的协议无需关注]

### 计算机网络相关
#### IP地址
> 编码格式：确定主机物理位置以完成通信
> 本地：localhost[主机名]、127.0.0.1[IP]
> IPV4[第四代互联网协议]：0~255 0~255 0~255 0~255;//4字节，分4端，每段1个字节，十进制表示，0~255[每字节占8位，4字节，共有2的32次方个地址] -> 点分十进制[点号分隔] => 34亿个地址，北美32亿，其它地方12亿，2012年就用完了，诞生了IPV6
> IPV6[第六代互联网协议]：xxx xxx xxx xxx xxx xxx xxx xxx;//16字节，分8段，每段2个字节，16进制表示[每字节占8位，16字节，共有2的128次方个地址] -> 冒分十六进制[冒号分隔]

#### 端口
> 其表示进程，不同进程有不同端口号 -> 用于区分软件
> 分类：
>    -> 0~65535[区分协议，也就是TCP/UDP各自有65535个，只要保证单协议下端口不冲突即可]
>    公有端口：0~1023, HTTP80、HTTPS443、FTP21、Telent23
>    程序注册端口：1024~49151, Tomcat8080、MySql3306、Oracle1521
>    动态、私有：49152~65535
```shell
  netstat -ano;//查看所有端口
  netstat -ano|findstr "5900";//查看指定端口 -> |符号在linux中表示过滤，在所有端口中过滤到5900端口
  tasklist|findstr "5900";//查看指定端口的进程[应用程序]
``` 

#### 协议
> TCP: 传输控制协议，面向连接的可靠传输[三次握手、四次挥手] -> 准确性高，效率较低，例如文件传输、接受邮件、远程登录
> UDP: 用户数据报协议，面向非连接的不可靠传输 -> 效率高，准确性较低，例如微信聊天、语音视频电话等，偶尔丢包无所谓
> -> 均具备差错控制、流量控制

#### 网络编程 vs 网页编程
> 网络编程：C/S架构，其没有很强的客户端、服务端区分，聚焦在各主机间的网络通信
> 网页编程：B/S架构，浏览器为服务请求方


### JAVA网络编程
> java.net包提供系列类和接口解决网络通信问题，屏蔽底层硬件相关，其提供了两种常见协议支持TCP、UDP，编程常用Socket、URL处理

#### Socket编程
> java.net.Socket类就是套接字，客户端创建套接字并尝试连接服务端的套接字，连接建立后通过I/O流通信

> 基于TCP
```java
/*
   基于TCP的通信：Socket套接字
   客户端
*/
package com.mi.net.tcp.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {
  public static void main(String[] args) throws UnknownHostException {
    InetAddress serverIp = InetAddress.getByName("127.0.0.1");
    int port = 9999;

    Socket socket = null;
    OutputStream os = null;
    try {
      socket = new Socket(serverIp,port);
      os = socket.getOutputStream();
      os.write("Hello,你好Hou".getBytes());
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

/*
  基于TCP的通信：Socket套接字
  服务端
*/
package com.mi.net.tcp.chat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
  public static void main(String[] args){
    ServerSocket serverSocket = null;
    Socket socket = null;
    InputStream is = null;
    ByteArrayOutputStream baos = null;

    try {
      serverSocket = new ServerSocket(9999);
      socket = serverSocket.accept();
      is = socket.getInputStream();

      baos = new ByteArrayOutputStream();
      byte[] buffer = new byte[1024];
      int len;
      while((len = is.read(buffer)) != -1) {
        baos.write(buffer,0,len);
      }
      System.out.println(baos.toString());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      // 关闭资源 -> 后开先关
      if(baos != null) {
        try {
          baos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if(is != null) {
        try {
          is.close();
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
      if(serverSocket != null) {
        try {
          serverSocket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
```

> 基于UDP
```java
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

/*
  基于UDP的通信：
*/
package com.mi.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo {
  public static void main(String[] args) throws Exception {
    // 创建服务 -> 开放端口
    DatagramSocket socket = new DatagramSocket(9000);
    // 接收数据包
    byte[] buffer = new byte[1024];
    DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

    socket.receive(packet);//阻塞接收

    System.out.println(packet.getAddress().getHostAddress());
    System.out.println(new String(packet.getData(),0,packet.getLength()));

    // 关闭连接
    socket.close();
  }
}
```