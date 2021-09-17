package com.mi.threadlock;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        UnSafeBuyTicket lockTicket = new UnSafeBuyTicket();

        new Thread(lockTicket,"a").start();
        new Thread(lockTicket,"b").start();
        new Thread(lockTicket,"c").start();


    }
}


class UnSafeBuyTicket implements Runnable{
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
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNums-- + "张票");

            } finally {
                // 解锁
                lock.unlock();

            }

        }
    }

    // 主线程
    public static void main(String[] args) {
        com.mi.threadsyn.UnSafeBuyTicket ticket = new com.mi.threadsyn.UnSafeBuyTicket();
        new Thread(ticket,"a").start();
        new Thread(ticket,"b").start();
        new Thread(ticket,"c").start();
    }
}


