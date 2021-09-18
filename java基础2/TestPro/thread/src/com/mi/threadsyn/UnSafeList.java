/*
    线程并发引起的问题：ArrayList是不安全的List集合 -> 线程不安全
*/
package com.mi.threadsyn;

import java.util.ArrayList;
import java.util.List;

public class UnSafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for(int i=0; i<10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        // 前面1000多线程并发执行，主线程执行到此处先sleep阻塞1000毫秒，然后再执行System.out.println(list.size());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}