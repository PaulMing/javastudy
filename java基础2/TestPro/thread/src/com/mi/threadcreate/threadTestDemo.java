/*
    线程创建方式一：
        继承Thread类，重写run()方法，调用start()开启线程
        -> 线程开启不一定立即执行，CPU调度执行
*/
package com.mi.threadcreate;

public class threadTestDemo extends Thread{
    @Override
    // run方法：定义线程体
    public void run() {
        for(int i=0; i<20; i++) {
            System.out.println("xxx");
        }
    }

    // 主线程
    public static void main(String[] args) {
        threadTestDemo testThread = new threadTestDemo();
        testThread.start();//开启线程

        for(int i=0; i<200; i++) {
            System.out.println("s");
        }
    }
}