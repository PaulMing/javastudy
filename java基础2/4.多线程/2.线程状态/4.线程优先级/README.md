## 线程优先级
> JAVA提供线程调度器监控程序启动后进入就绪状态的所有线程[就绪队列]，调度器会按照优先级决定线程执行顺序 -> 实际优先级仅代表调度的概率/权值，优先级低仅表示调度概率低，开发中会出现优先级低反而先调度的情况，也就是所谓的'性能倒置'，此情况很少发生但有概率发生

### 优先级设置
> setPriority(int xx);//范围1~10, 负数/小数/越界数均会报错
> getPriority();
> Thread.MIN_PRIORITY;//最小值 1
> Thread.MAX_PRIORITY;//最大值 10
> Thread.NORM_PRIORITY;//默认值 5

```java
package com.mi.threadstatus;

public class TestPriorityDemo {
  public static void main(String[] args) {
    // 主线程优先级是JVM默认的，无法更改
    System.out.println("主线程优先级：" + Thread.currentThread().getName() + " -> " + Thread.currentThread().getPriority());

    MyPriority myPriority = new MyPriority();
    Thread t1 = new Thread(myPriority,"t1");
    Thread t2 = new Thread(myPriority,"t2");
    Thread t3 = new Thread(myPriority,"t3");
    Thread t4 = new Thread(myPriority,"t4");
    Thread t5 = new Thread(myPriority,"t5");
    Thread t6 = new Thread(myPriority,"t6");

    // 先设置优先级、再启动
    t1.start();//不设置，默认值为5

    t2.setPriority(2);
    t2.start();

    t3.setPriority(3);
    t3.start();

    // t4.setPriority(-2);// 负数会报错
    // t4.start();

    t5.setPriority(Thread.MAX_PRIORITY);//最大的优先级
    t5.start();

    // t6.setPriority(11);// 数字越界会报错
    // t6.start();
  }
}

class MyPriority implements Runnable {
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " -> " + Thread.currentThread().getPriority());
  }
}
```