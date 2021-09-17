## 守护线程
> JAVA线程分为用户线程、守护线程：JVM虚拟机确保用户线程执行完毕即可，不用等待守护线程执行完毕，守护线程等同于在幕后运行，用户级线程结束了，其也就结束了
> 用户级线程：main线程、创建的线程[默认都是用户级线程]
> 守护线程：GC垃圾回收线程、后台记录操作日志、监控内存等 -> 调用方法设置即可：setDaemon(true);//默认值为false表示用户级线程

```java
package com.mi.threadstatus;

public class TestDaemonDemo {
  public static void main(String[] args) {
    Guard guard = new Guard();
    User user = new User();

    //设置守护线程
    Thread guardThread = new Thread(guard);
    guardThread.setDaemon(true);//默认值为false表示用户级线程
    guardThread.start();

    // 用户线程
    new Thread(user).start();
  }
}

class Guard implements Runnable{
  @Override
  public void run() {
    System.out.println("守护线程---");
  }
}

class User implements Runnable{
  @Override
  public void run() {
    for(int i=0; i<1000000; i++) {
      System.out.println("用户级线程---");
    }
    System.out.println("用户级线程结束---");
  }
}
```