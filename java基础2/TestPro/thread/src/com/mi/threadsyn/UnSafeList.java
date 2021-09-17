/*
    线程优先级：1~10 -> 默认值是5，负数、越界、小数会报错
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
        System.out.println(list.size());
    }
}
