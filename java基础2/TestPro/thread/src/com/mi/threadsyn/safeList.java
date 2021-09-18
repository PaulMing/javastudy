/*
    锁机制解决并发问题：ArrayList是不安全的List集合
*/
package com.mi.threadsyn;

import java.util.ArrayList;
import java.util.List;

public class safeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for(int i=0; i<10000; i++) {
            new Thread(() -> {
                // 同步快：锁对象[锁变化的量]
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
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