/*
   信号灯法：设置标志位
*/
package com.mi.threadinfo;

public class TestLight {
    public static void main(String[] args) {
        Program program = new Program();
        Player player = new Player(program);
        Watcher watcher = new Watcher(program);

        new Thread(player,"player").start();
        new Thread(watcher,"watcher").start();
    }
}

// 演员 -> 生产者
class Player implements Runnable{
    Program program;
    public Player(Program program) {
        this.program = program;
    }

    @Override
    public void run() {
        for(int i=0; i<20; i++) {
            if(i%2 == 0) {
                this.program.play("表演节目xx");
            } else {
                this.program.play("节目广告");
            }
        }
    }
}


// 观众 -> 消费者
class Watcher implements Runnable {
    Program program;
    public Watcher(Program program) {
        this.program = program;
    }

    @Override
    public void run() {
        for(int i=0; i<20; i++) {
            program.watch();
        }
    }

}

// 节目 -> 产品
class Program {
    String voice;
    boolean flag = true; // 演员表演，观众等待 true; 观众观看，演员等待 false;

    // 表演
    public synchronized void play(String voice) {
        // 若观众观看，演员等待
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了：" + voice);
        // 通知观众观看
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }

    // 观看
    public synchronized void watch() {
        // 若已在表演，观众等待
        if(flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了：" + voice);
        // 通知演员表演
        this.notifyAll();
        this.flag = !this.flag;
    }
}