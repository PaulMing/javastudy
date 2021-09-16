/*
    线程礼让
*/
package com.mi.threadstatus;

public class TestYieldDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程结束执行");
    }

    // main线程
    public static void main(String[] args) {
        TestYieldDemo yield1 = new TestYieldDemo();
        TestYieldDemo yield2 = new TestYieldDemo();

        new Thread(yield1,"a").start();
        new Thread(yield2,"b").start();
    }
}