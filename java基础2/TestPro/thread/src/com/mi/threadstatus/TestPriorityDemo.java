/*
    线程优先级：1~10 -> 默认值是5，负数、越界、小数会报错
*/
package com.mi.threadstatus;

public class TestPriorityDemo {
    public static void main(String[] args) {
        // 主线程优先级是JVM默认的，无法更改
        System.out.println("主线程优先级：" + Thread.currentThread().getName() + " -> " + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority,"t1");
        Thread t2 = new Thread(myPriority,"t2");
        Thread t3 = new Thread(myPriority,"t3");
        Thread t4 = new Thread(myPriority,"t4");
        Thread t5 = new Thread(myPriority,"t5");
        Thread t6 = new Thread(myPriority,"t6");

        // 先设置优先级、再启动
        t1.start();//不设置，默认值为5

        t2.setPriority(2);
        t2.start();

        t3.setPriority(3);
        t3.start();

//        t4.setPriority(-2);// 负数会报错
//        t4.start();

        t5.setPriority(Thread.MAX_PRIORITY);//最大的优先级
        t5.start();

//        t6.setPriority(11);// 数字越界会报错
//        t6.start();
    }
}

class MyPriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " -> " + Thread.currentThread().getPriority());
    }
}