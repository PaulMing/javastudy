## 线程礼让
> 本质：线程状态的切换，运行态转换为就绪态，当前线程暂停但不阻塞
> 礼让不一定成功，取决于CPU'心情'
```java
package com.mi.threadstatus;

public class TestYieldDemo implements Runnable {
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + "线程开始执行");
    Thread.yield();
    System.out.println(Thread.currentThread().getName() + "线程结束执行");
  }

  // main线程
  public static void main(String[] args) {
    TestYieldDemo yield1 = new TestYieldDemo();
    TestYieldDemo yield2 = new TestYieldDemo();

    new Thread(yield1,"a").start();
    new Thread(yield2,"b").start();
  }
}
```