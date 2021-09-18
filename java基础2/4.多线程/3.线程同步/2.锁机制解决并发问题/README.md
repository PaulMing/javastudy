## 锁机制解决并发问题
> java提供锁机制：同步方法、同步快，均使用synchronized关键字实现 -> 实际就是每个对象对应一把锁，同步方法/同步块对该对象操作，它们获得锁后才能执行，否则线程就处于阻塞状态，例如同步方法处理某对象时，也就是获得一把锁，其会开始执行，方法执行结束释放该锁[还给对象]，后面的线程才能获得该锁，继续往下执行
> 开发建议：并发操作都添加上同步方法、同步快[只读操作也不用添加、修改操作需要添加]，不涉及并发操作的不要添加，其会影响效率

### 同步方法
> public synchronized void method() {}
```java
package com.mi.threadsyn;

public class safeBuyTicket implements Runnable{
  private int ticketNums = 10;

  @Override
  // 同步方法
  public synchronized void run() {
    while(true) {
      if(ticketNums <= 0) {
        break;
      }
      System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNums-- + "张票");
    }
  }

  // 主线程
  public static void main(String[] args) {
    UnSafeBuyTicket ticket = new UnSafeBuyTicket();
    new Thread(ticket,"a").start();
    new Thread(ticket,"b").start();
    new Thread(ticket,"c").start();
  }
}
```


### 同步快
> synchronized(Obj) {};//Obj称之为同步监视器，使用共享资源[实际就是变化量(变化的对象)]作为同步监视器 -> 同步方法无需指定监视器，默认就是this，对象本身或者是class
```java
package com.mi.threadsyn;

import java.util.ArrayList;
import java.util.List;

public class safeList {
  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    for(int i=0; i<10000; i++) {
      new Thread(() -> {
        // 同步快：锁对象[锁变化的量]
        synchronized (list) {
          list.add(Thread.currentThread().getName());
        }
      }).start();
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(list.size());// size不等于10000，有些位置数据被反复添加，数据被冲掉了 -> 加入sleep阻塞，效果会好些
  }
}
```