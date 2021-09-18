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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());// size不等于10000，有些位置数据被反复添加，数据被冲掉了 -> 加入sleep阻塞，效果会好些
    }
}