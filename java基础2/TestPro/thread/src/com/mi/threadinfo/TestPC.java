/*
   管程法：设置缓冲区
      类：生产者、消费者、产品、缓冲区 -> 生产者、消费者是线程
         生产者：仅关注生产产品
         消费者：仅关注消费产品
         缓冲区：负责通信，生产者放入、消费者取出
*/
package com.mi.threadinfo;

public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        Productor productor = new Productor(container);
        Consumer consumer = new Consumer(container);

        new Thread(productor,"productor").start();
        new Thread(consumer,"consumer").start();
    }
}

// 生产者
class Productor implements Runnable{
    SynContainer container;
    public Productor(SynContainer container) {
        this.container = container;
    }

    // 生产
    @Override
    public void run() {
        for(int i=0; i<100; i++) {
           System.out.println("生产了" + i + "只鸡");
           container.push(new Chicken(i));
        }
    }
}

// 消费者
class Consumer implements Runnable{
    SynContainer container;
    public Consumer(SynContainer container) {
        this.container = container;
    }

    // 消费
    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println("消费了" + container.pop().id + "只鸡");
        }
    }
}

// 产品
class Chicken {
    int id;
    public Chicken(int id) {
        this.id = id;
    }
}

// 缓存区
class SynContainer {
    // 容器
    Chicken[] chickens = new Chicken[10];
    // 计数器
    int count = 0;

    // 生产者放入产品
    public synchronized void push(Chicken chicken) {
        // 容器存满，则等待消费
        if(count == chickens.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            // 容器未满，丢入产品
            chickens[count] = chicken;
            count++;
            // 通知消费者消费
            this.notifyAll();
        }
    }

    // 消费者取出产品
    public synchronized Chicken pop() {
        // 容器没产品，则通知消费者生产，消费者等待
        if(count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            // 容器有产品，消费产品
            count--;
            Chicken chicken = chickens[count];
            // 吃完了，通知生产者生产
            this.notifyAll();
            return chicken;
        }
        return null;
    }
}