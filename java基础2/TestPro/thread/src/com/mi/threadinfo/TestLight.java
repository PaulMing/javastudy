/*
   信号灯：标志位解决


   类：生产者、消费者、产品、缓冲区
*/
//package com.mi.threadinfo;
//
//public class TestLight {
//    public static void main(String[] args) {
//        Program program = new Program();
//
//        Player player = new Player(program);
//        Watcher watcher = new Watcher(program);
//
//        new Thread(player).start();
//        new Thread(watcher).start();
//
//
//
//    }
//
//
//
//}
//
//
//// 演员
//class Player implements Runnable {
//    Program program;
//    public Player(Program program) {
//        this.program = program;
//
//    }
//
//    @Override
//    public void run() {
//        for(int i=0; i<20; i++) {
//            if(i%2 == 0) {
//                this.program.play("ss");
//            } else {
//                this.program.play("");
//            }
//        }
//    }
//
//}
//
//
//// 观众
//class Watcher implements Runnable {
//    Program program;
//    public Watcher(Program program) {
//        this.program = program;
//
//    }
//
//    @Override
//    public void run() {
//        for(int i=0; i<20; i++) {
//            program.watch();
//        }
//    }
//
//}
//
//
//// 节目
//class Program {
//    String voice;
//    boolean flag = true;
//
//
//    // 表演
//    public synchronized void play(String voice) {
//        if (!flag) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("表演了：" + voice);
//        this.notifyAll();
//        this.voice = voice;
//        this.flag = !this.flag;
//
//    }
//
//    // 观看
//    public synchronized void play(String voice) {
//        if(flag) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("观看了：" + voice);
//        // 通知演员表演
//        this.notifyAll();
//        this.flag = !this.flag;
//
//    }
//
//}
