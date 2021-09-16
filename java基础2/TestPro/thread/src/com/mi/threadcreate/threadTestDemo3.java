/*
   并发问题：购票
*/
package com.mi.threadcreate;

public class threadTestDemo3 implements Runnable{
    private int ticketNums = 10;

    @Override
    public void run() {
        while(true) {
            if(ticketNums <= 0) {
                break;
            }

            // 模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        threadTestDemo3 ticket = new threadTestDemo3();

        new Thread(ticket,"a").start();
        new Thread(ticket,"b").start();
        new Thread(ticket,"c").start();
    }
}