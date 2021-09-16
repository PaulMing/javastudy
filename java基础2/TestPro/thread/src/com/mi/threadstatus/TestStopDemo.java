/*
    线程停止：终止状态
*/
package com.mi.threadstatus;

public class TestStopDemo implements Runnable{
    // 标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while(flag) {
            System.out.println("输出：" + i);
        }
    }

    // stop
    public void stop() {
        this.flag = false;
    }

    // main主线程
    public static void main(String[] args) {
        TestStopDemo testStopDemo = new TestStopDemo();
        new Thread(testStopDemo,"stop").start();

        for(int i = 0; i<=100000; i++) {
            if(i == 100000) {
              testStopDemo.stop();
              System.out.println("线程停止");
            }
        }
    }
}