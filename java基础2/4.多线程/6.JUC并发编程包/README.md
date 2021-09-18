## JUC并发编程包 -> java.util.concurrent工具包
> JDK1.5出现的处理多线程工具包，其包括常用的安全类型集合、解决死锁等方案 -> 开发中经常会使用该库

### RenntrantLock可重入锁
> JUC包提供的工具类，其拥有与synchronized相同的并发性和内存语义

> RenntrantLock VS synchronized
> RenntrantLock是显示加锁、解锁[不要忘记关锁],JVM花费更少时间调度线程，性能更好，也有更好的扩展性[提供更多子类]
> synchronized是隐式锁，出了作用域自动释放
> 建议使用顺序：RenntrantLock > synchronized[同步代码块 > 同步方法]

```java
/*
  class A {
    // 定义锁
    private final ReentrantLock lock = new ReentrantLock();
    public void func() {
      // 其建议：解锁放入到fianally部分try{}finally{}，加锁写不写到try都可以
      try {
        lock.lock();//加锁
        // 线程不安全代码部分
      } finally {
        lock.unlock();//解锁
      }
    }
  }
*/
package com.mi.threadjuc;

import java.util.concurrent.locks.ReentrantLock;

public class TestJUCLock {
  public static void main(String[] args) {
    buyTicket ticket = new buyTicket();

    new Thread(ticket,"a").start();
    new Thread(ticket,"b").start();
    new Thread(ticket,"c").start();
  }
}

class buyTicket implements Runnable{
  private int ticketNums = 10;
  // 定义lock锁
  private final ReentrantLock lock = new ReentrantLock();

  @Override
  public void run() {
    while(true) {
      try {
        // 加锁
        lock.lock();
        if(ticketNums <= 0) {
            break;
        }
        System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNums-- + "张票");
      } finally {
        // 解锁
        lock.unlock();
      }
    }
  }
}
```

### CopyOnWriteArrayList集合
> JUC包提供的工具类，安全类型集合

```java
package com.mi.threadjuc;

import java.util.concurrent.CopyOnWriteArrayList;

public class TestJUC {
  public static void main(String[] args) {
    // JUC提供的安全类型集合 -> 线程安全
    CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
    for(int i=0; i<10000; i++) {
      new Thread(() -> {
        list.add(Thread.currentThread().getName());
      }).start();
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(list.size());
  }
}
```