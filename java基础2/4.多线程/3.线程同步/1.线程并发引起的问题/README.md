## 线程并发引起的系列问题
> 本质：多线程并发操作同一个数据引起的'线程不安全'

### 购票 -> 线程不安全
```java
package com.mi.threadsyn;

public class UnSafeBuyTicket implements Runnable{
  private int ticketNums = 10;

  @Override
  public void run() {
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

### ArrayList是不安全的List集合 -> 线程不安全
```java
package com.mi.threadsyn;

import java.util.ArrayList;
import java.util.List;

public class UnSafeList {
  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
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
    System.out.println(list.size());// size不等于10000，有些位置数据被反复添加，数据被冲掉了 -> 加入sleep阻塞，效果会好些
  }
}
```