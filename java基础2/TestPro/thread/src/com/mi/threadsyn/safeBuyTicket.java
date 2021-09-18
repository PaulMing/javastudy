/*
    锁机制解决并发问题：购票
*/
package com.mi.threadsyn;

public class safeBuyTicket implements Runnable{
    private int ticketNums = 10;

    @Override
    // 同步方法
    public synchronized void run() {
        while(true) {
            if(ticketNums <= 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNums-- + "张票");
        }
    }

    // 主线程
    public static void main(String[] args) {
        UnSafeBuyTicket ticket = new UnSafeBuyTicket();
        new Thread(ticket,"a").start();
        new Thread(ticket,"b").start();
        new Thread(ticket,"c").start();
    }
}