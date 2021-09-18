/*
    线程池
*/
package com.mi.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 执行
        service.execute(new dealThread());
        service.execute(new dealThread());
        service.execute(new dealThread());
        service.execute(new dealThread());

        // 关闭线程池
        service.shutdown();
    }
}

class dealThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}