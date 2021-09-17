/*
    线程优先级：1~10 -> 默认值是5，负数、越界、小数会报错
*/
package com.mi.threadsyn;

public class UnSafeBuyTicket implements Runnable{
    private int ticketNums = 10;

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