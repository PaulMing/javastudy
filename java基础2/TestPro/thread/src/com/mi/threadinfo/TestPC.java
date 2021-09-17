/*
   管程法：利用缓冲区解决


   类：生产者、消费者、产品、缓冲区
*/
package com.mi.threadinfo;

import java.beans.beancontext.BeanContextChildComponentProxy;

public class TestPC {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        Productor productor = new Productor(container);
        Consumer consumer = new Consumer(container);

        new Thread(productor).start();
        new Thread(consumer).start();
    }


}

//
class Productor implements Runnable {
    SynContainer container;
    public Productor(SynContainer container) {
        this.container = container;
    }

    // 生产
    @Override
    public void run() {
        for(int i=0; i<100; i++) {

           container.push(new Chilcken(i));
           System.out.println("生产了" + i + "只鸡");
        }
    }
}

class Consumer implements Runnable {
    SynContainer container;
    public Consumer(SynContainer container) {
        this.container = container;
    }

    // 消费
    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println("生产了" + container.pop() + "只鸡");
            container.push(new Chilcken(i));
        }
    }

}

class Chilcken implements Runnable {

}

class SynContainer {
    Chilcken[] chickens = new Chilcken[10];
    int count = 0;

    // 生产者放入产品
    public synchronized void push(Chilcken chilcken) {
        // 满了，等待消费
        if(count == chilcken.length) {
            //
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {
            // 丢入产品
            chickens[count] = chicken;
            count++;
            // 通知消费者消费
            this.notifyAll();
        }

    }


    // 取出产品
    public synchronized void pop() {
        //
        if(count == 0) {
            // 等待生产者生产，消费者等待

        } else {
            count--;
            Chilcken chicken = chickens[count];
            // 吃完了，通知生产者生产


            return chicken;

        }
    }

}