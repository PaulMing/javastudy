/*
    线程并发引起的问题：购票 -> 线程不安全
*/
package com.mi.threadsyn;

public class UnSafeBuyTicket implements Runnable{
    private int ticketNums = 10;

    @Override
    public void run() {
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