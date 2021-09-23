## 性能分析
```java
/*
  性能对比分析：
      反射方式调用[关闭检测] > 反射方式调用 > 普通方式调用
*/
package com.mi.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect7 {
  // 普通方式调用
  public static void test1() {
    User user = new User();
    long startTime = System.currentTimeMillis();
    for(int i=0; i < 1000000000; i++) {
      user.getName();
    }
    long endTime = System.currentTimeMillis();
    System.out.println("普通方式调用：" + (endTime - startTime) + "ms");
  }

  // 反射方式调用
  public static void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    User user = new User();
    Class c1 = user.getClass();
    Method getName = c1.getDeclaredMethod("getName",null);

    long startTime = System.currentTimeMillis();
    for(int i=0; i < 1000000000; i++) {
        getName.invoke(user,null);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("反射方式调用：" + (endTime - startTime) + "ms");
  }

  // 反射方式调用[关闭检测]
  public static void test3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    User user = new User();
    Class c1 = user.getClass();
    Method getName = c1.getDeclaredMethod("getName",null);
    getName.setAccessible(true);// 关闭检测

    long startTime = System.currentTimeMillis();
    for(int i=0; i < 1000000000; i++) {
      user.getName();
    }
    long endTime = System.currentTimeMillis();
    System.out.println("反射方式调用[关闭检测]：" + (endTime - startTime) + "ms");
  }

  public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
    TestReflect7 demo = new TestReflect7();
    demo.test1();
    demo.test2();
    demo.test3();
  }
}
```