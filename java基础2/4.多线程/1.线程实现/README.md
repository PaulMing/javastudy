## 线程实现
> JAVA提供了三种创建方法：
> 方式一：每次都需要创建对象、OOP单继承有局限性 -> 不推荐使用，仅次于方式二
> 方式二：同一个对象可多次使用，不用多次创建，性能更好，也更符合'高并发编程'[很多时候并发执行同类任务] -> 推荐使用
> 方式三：基本不用

### 线程创建方式一
```java
/*
  线程创建方式一：
    继承Thread类，重写run()方法，调用start()开启线程
    -> 线程开启不一定立即执行，CPU调度执行
*/
package com.mi.thread;

public class threadTestDemo extends Thread{
  @Override
  // run方法：定义线程体
  public void run() {
    for(int i=0; i<20; i++) {
      System.out.println("xxx");
    }
  }

  // 主线程
  public static void main(String[] args) {
    threadTestDemo testThread = new threadTestDemo();
    testThread.start();//开启线程

    for(int i=0; i<200; i++) {
      System.out.println("s");
    }
  }
}
```

### 线程创建方式二
```java
/*
  线程创建方式二：
    实现runnable接口，重写run()方法，然后将runnable接口实现类作为thread类的参数传入，调用start方法
*/
package com.mi.thread;

public class threadTestDemo2 implements Runnable{
  @Override
  // run方法：定义线程体
  public void run () {
    for(int i=0; i<20; i++) {
      System.out.println("xxx");
    }
  }

  // 主线程
  public static void main(String[] args) {
    threadTestDemo2 testThread = new threadTestDemo2();
    Thread thread = new Thread(testThread);
    thread.start();

    for(int i=0; i<200; i++) {
      System.out.println("s");
    }
  }
}
```

### 线程创建方式三
```java
/*
  线程创建方式三：
    1.实现callable接口【泛型接口】,重写call方法，需要抛出异常
    2.创建执行服务对象：ExecutorService ser = Executors.newFixedThreadPool(3);
    3.提交执行：Future<Boolean> r1 = ser.submit(t1);
    4.获取结果：boolean rs1 = r1.get();
    5.关闭服务：ser.shutdownNow();
*/
package com.mi.thread;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class threadTestDemo5 implements Callable<Boolean> {
  public String url;
  public String name;

  public threadTestDemo5(String url, String name) {
    this.url = url;
    this.name = name;
  }

  @Override
  public Boolean call() {
    WebDownLoader webDownLoader = new WebDownLoader();
    webDownLoader.downloader(url,name);
    System.out.println("download:" + name);
    return true;
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    threadTestDemo5 t1 = new threadTestDemo5("http://mat1.gtimg.com/sports/kbsweb4/assets/176e7c5f3d7dffbd0d7d.png", "1.jpg");
    threadTestDemo5 t2 = new threadTestDemo5("http://mat1.gtimg.com/sports/kbsweb4/assets/176e7c5f3d7dffbd0d7d.png", "2.jpg");
    threadTestDemo5 t3 = new threadTestDemo5("http://mat1.gtimg.com/sports/kbsweb4/assets/176e7c5f3d7dffbd0d7d.png", "3.jpg");

    // 创建执行服务
    ExecutorService ser = Executors.newFixedThreadPool(3);

    // 提交执行
    Future<Boolean> r1 = ser.submit(t1);
    Future<Boolean> r2 = ser.submit(t2);
    Future<Boolean> r3 = ser.submit(t3);

    // 获取结果
    boolean rs1 = r1.get();
    boolean rs2 = r2.get();
    boolean rs3 = r3.get();
    System.out.println(rs1);
    System.out.println(rs2);
    System.out.println(rs3);

    // 关闭服务
    ser.shutdownNow();
  }
}
```