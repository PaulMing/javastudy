/*
   ip
*/
package com.mi.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) throws UnknownHostException {
        // 获取本机IP地址 -> 等同于ping
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        InetAddress inetAddress1 = InetAddress.getByName("localhost");
        InetAddress inetAddress2 = InetAddress.getLocalHost();
        System.out.println(inetAddress);
        System.out.println(inetAddress1);
        System.out.println(inetAddress2);

        // 获取xx IP地址
        InetAddress inetAddress3 = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress3);


        inetAddress3.getAddress();// 字节数组
        inetAddress3.getHostAddress();// ip
        inetAddress3.getCanonicalHostName();// 规范名字，实际也是ip
        inetAddress3.getHostName();// 主机名





    }
}
