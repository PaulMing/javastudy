/*
    JUC并发编程包：java.util.concurrent工具包
        -> JDK1.5出现的处理多线程工具包，其包括常用的安全类型集合、解决死锁等方案
*/
package com.mi.threadjuc;

import java.util.concurrent.CopyOnWriteArrayList;

public class TestJUCList {
    public static void main(String[] args) {
        // JUC提供的安全类型集合 -> 线程安全
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for(int i=0; i<10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}