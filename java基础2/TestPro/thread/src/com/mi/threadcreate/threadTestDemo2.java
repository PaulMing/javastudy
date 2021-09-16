/*
    线程创建方式二：
       实现runnable接口，重写run()方法，然后将runnable接口实现类作为thread类的参数传入，调用start方法
*/
package com.mi.threadcreate;

public class threadTestDemo2 implements Runnable{
    @Override
    // run方法：定义线程体
    public void run () {
        for(int i=0; i<20; i++) {
            System.out.println("xxx");
        }
    }

    // 主线程
    public static void main(String[] args) {
        threadTestDemo2 testThread = new threadTestDemo2();
        Thread thread = new Thread(testThread);
        thread.start();

        for(int i=0; i<200; i++) {
            System.out.println("s");
        }
    }
}