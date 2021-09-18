/*
   死锁：某一个同步块同时拥有'两个以上对象的锁'时,就有可能发生'死锁问题'
*/
package com.mi.threadsyn.lock;

public class TestDeadLock {
    public static void main(String[] args) {
        Makeup u1 = new Makeup(0,"a");
        Makeup u2 = new Makeup(1,"b");

        new Thread(u1).start();
        new Thread(u2).start();
    }
}

// 口红
class Lipstick {

}

// 镜子
class Mirror {

}

// 化妆
class Makeup implements Runnable {
    int choice;
    String userName;
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror =  new Mirror();

    Makeup(int choice, String userName) {
        this.choice = choice;
        this.userName = userName;
    }

    private void makeup() throws InterruptedException {
        if(choice == 0) {
            synchronized(lipstick) {
                System.out.println(this.userName + "获得口红");
                Thread.sleep(1000);
                synchronized(mirror) {
                    System.out.println(this.userName + "获得镜子");
                }
            }
        } else {
            synchronized(mirror) {
                System.out.println(this.userName + "获得镜子");
                Thread.sleep(2000);
                synchronized(lipstick) {
                    System.out.println(this.userName + "获得口红");
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}