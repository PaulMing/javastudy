/*
   死锁解决：某一个同步块不同时拥有'两个以上对象的锁'
*/
package com.mi.threadsyn.lock;

public class TestDealDeadLock {
    public static void main(String[] args) {
        MakeupDeal u1 = new MakeupDeal(0,"a");
        MakeupDeal u2 = new MakeupDeal(1,"b");

        new Thread(u1).start();
        new Thread(u2).start();
    }
}

// 口红
class LipstickDeal {

}

// 镜子
class MirrorDeal {

}

class MakeupDeal implements Runnable {
    int choice;
    String userName;
    static LipstickDeal lipstickDeal = new LipstickDeal();
    static MirrorDeal mirrorDeal =  new MirrorDeal();

    MakeupDeal(int choice, String userName) {
        this.choice = choice;
        this.userName = userName;
    }


    private void makeup() throws InterruptedException {
        if(choice == 0) {
            synchronized(lipstickDeal) {
                System.out.println(this.userName + "获得口红");
                Thread.sleep(1000);
            };
            synchronized(mirrorDeal) {
                System.out.println(this.userName + "获得镜子");
            };
        } else {
            synchronized(mirrorDeal) {
                System.out.println(this.userName + "获得镜子");
                Thread.sleep(2000);
            };
            synchronized(lipstickDeal) {
                System.out.println(this.userName + "获得口红");
            };
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