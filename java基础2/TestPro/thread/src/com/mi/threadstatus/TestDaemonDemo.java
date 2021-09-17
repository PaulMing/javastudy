/*
    用户级线程 vs 守护线程
*/
package com.mi.threadstatus;

public class TestDaemonDemo {
    public static void main(String[] args) {
        Guard guard = new Guard();
        User user = new User();

        //设置守护线程
        Thread guardThread = new Thread(guard);
        guardThread.setDaemon(true);//默认值为false表示用户级线程
        guardThread.start();

        // 用户线程
        new Thread(user).start();
    }
}

class Guard implements Runnable{
    @Override
    public void run() {
        System.out.println("守护线程---");
    }
}

class User implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<1000000; i++) {
            System.out.println("用户级线程---");
        }
        System.out.println("用户级线程结束---");
    }
}