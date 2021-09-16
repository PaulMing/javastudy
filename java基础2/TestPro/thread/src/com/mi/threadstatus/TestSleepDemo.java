/*
    线程停止：阻塞状态
*/
package com.mi.threadstatus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleepDemo {

    // 模拟倒计时
    public static void CountDown() throws InterruptedException {
        int num = 10;
        while(true) {
            Thread.sleep(1000);
            System.out.println(num--);
            if(num <= 0) {
                break;
            }
        }
    }

    // 系统时间
    public static void systemTime() {
        Date startTime = new Date(System.currentTimeMillis());
        while(true) {
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // main主线程
    public static void main(String[] args) {
//        try {
//            TestSleepDemo.CountDown();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        TestSleepDemo.systemTime();
    }
}
