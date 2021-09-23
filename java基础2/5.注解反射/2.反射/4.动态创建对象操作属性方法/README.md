## 动态创建对象操作属性方法
```java
package com.mi.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect4 {
  public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
    // Class c1 = Class.forName("com.mi.reflect.User1");
    // System.out.println(c1);
    User1 ur = new User1();
    Class c1 = ur.getClass();

    // 构造对象：默认调用无参构造器
    User1 user = (User1)c1.newInstance();
    System.out.println(user);
    // 构造对象：调用有参构造器
    Constructor constructor = c1.getConstructor(String.class,int.class,int.class);
    User1 user1 = (User1)constructor.newInstance("a",1,1);
    System.out.println(user1);

    // 调用方法
    Method setName = c1.getDeclaredMethod("setName",String.class);
    setName.invoke(user,"a");// invoke:激活 -> invoke(对象，参数)
    System.out.println(user.getName());

    // 操作属性
    Field name = c1.getDeclaredField("name");
    name.setAccessible(true);//安全检测关掉，关掉才可操作私有属性 -> 默认是false; true:关掉、false:开启
    name.set(user,"b");
  }
}

class User1 {
  private String name;
  private int id;
  private int age;

  public User1(String name, int id, int age) {
    this.name = name;
    this.id = id;
    this.age = age;
  }
  public User1() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
```