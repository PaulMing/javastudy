/*
    线程强制执行
*/
package com.mi.threadstatus;

public class TestJoinDemo implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<1000; i++) {
            System.out.println("线程vip");
        }
    }

    public static void main(String[] args) {
        TestJoinDemo testJoin = new TestJoinDemo();
        Thread thread = new Thread(testJoin);
        thread.start();

        // 主线程
        for(int i=0; i<100; i++) {
            if(i== 30) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("主线程");
        }
    }
}