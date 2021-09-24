package com.mi.net;

import java.net.InetSocketAddress;

public class TestSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
        System.out.println(socketAddress);
        socketAddress.getAddress();
        socketAddress.getHostName();
        socketAddress.getPort();
    }
}