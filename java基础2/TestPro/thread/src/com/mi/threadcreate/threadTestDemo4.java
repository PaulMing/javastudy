/*
    并发问题：龟兔赛跑
*/
package com.mi.threadcreate;

public class threadTestDemo4 implements Runnable{
    private String winner;

    @Override
    public void run() {
        for(int i=0; i<=100; i++) {
            // 模拟兔子休息
            if(Thread.currentThread().getName().equals("rabbit") && i%10 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(gameOver(i)) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    // 判断是否结束比赛
    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        }
        if(steps >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        threadTestDemo4 race = new threadTestDemo4();
        new Thread(race,"rabbit").start();
        new Thread(race,"tortoise").start();
    }
}