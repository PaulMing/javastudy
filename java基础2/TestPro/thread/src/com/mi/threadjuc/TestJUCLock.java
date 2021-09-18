/*
    ReentrantLock可重入锁
      JUC包提供的工具类，其拥有与synchronized相同的并发性和内存语义，其是显示的加锁、解锁
*/
package com.mi.threadjuc;

import java.util.concurrent.locks.ReentrantLock;

public class TestJUCLock {
    public static void main(String[] args) {
        buyTicket ticket = new buyTicket();

        new Thread(ticket,"a").start();
        new Thread(ticket,"b").start();
        new Thread(ticket,"c").start();
    }
}

class buyTicket implements Runnable{
    private int ticketNums = 10;
    // 定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true) {
            try {
                // 加锁
                lock.lock();
                if(ticketNums <= 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNums-- + "张票");
            } finally {
                // 解锁
                lock.unlock();
            }
        }
    }
}