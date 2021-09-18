## 线程池
> 背景：频繁的创建、销毁占用资源较多的线程，对性能影响很大
> 线程池：提前创建线程放入线程池中，使用时直接获取，使用完成后放入池中，全部使用结束后统一销毁 -> 无需频繁的创建、销毁

> 优点：
> 响应速度快、资源消耗少：减少创建新线程的时间，重复使用线程池中线程
> 便于线程管理：
>     corePoolSize: 核心池的大小
>     maximumPoolSize: 最大线程数
>     keepAliveTime: 线程没有任务时最多保持多长时间后会终止

```java
/*
  JDK5.0提供了线程池API：
    ExecutorService: 线程池接口，常见子类ThreadPoolExecutor
      void execute(): 执行任务/命令，常用于执行Runnable
      <T>Future<T>submit(Callable<T>task): 常用于执行Callable
      void shutdown(): 关闭连接池

    Executors: 工具类、线程池的工厂类，用于创建并返回不同类型的线程池
*/
package com.mi.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
  public static void main(String[] args) {
    // 创建线程池
    ExecutorService service = Executors.newFixedThreadPool(10);

    // 执行
    service.execute(new dealThread());
    service.execute(new dealThread());
    service.execute(new dealThread());
    service.execute(new dealThread());

    // 关闭线程池
    service.shutdown();
  }
}

class dealThread implements Runnable {
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName());
  }
}
```