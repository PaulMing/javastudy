## 反射 -> 动态性
> 其允许程序执行期借助Reflection API取得任何类的内部信息，类转换为类对象后可直接操作属性及方法，开发很便捷[面向对象思想] -> 其让JAVA这种静态语言具备'动态性'，程序运行期可做很多事情，等同于'Hook钩子'，很多框架就是基于反射机制 + 注解实现，功能异常强大，编程非常灵活，但反射对性能有影响[插入执行期必然影响原有性能]
> 类加载机制：类加载完成后，系统就会在堆内存中产生该类的Class类型对象，也就是类是创建对象的模板，类本身也是对象 => 仅系统可创建 && 仅能创建一次
> 聚焦：获取类对象、所有类型的Class类对象、获取类对象运行时的内部结构[属性、方法等]、动态创建对象操作属性方法、操作泛型信息、操作注解信息、性能分析

### 获取类对象
```java
package com.mi.reflect;

public class TestReflect1 {
  public static void main(String[] args) throws ClassNotFoundException {
    // 获取类对象的三种方式
    // 方式1：obj.getClass()
    Person person = new Student();
    Class c1 = person.getClass();
    System.out.println(c1.hashCode());

    // 方式2：Class.forName(类名)
    Class c2 = Class.forName("com.mi.reflect.Student");
    System.out.println(c2.hashCode());

    // 方式3：类名.class
    Class c3 = Student.class;
    System.out.println(c3.hashCode());

    // 基本内置类型的包装类都有一个type属性,属性值为类对象 -> 仅限包装类
    Class c7 = Integer.TYPE;
    System.out.println(c7.hashCode());

    // 获得父类类型
    Class c8 = c1.getSuperclass();
    System.out.println(c8);
  }
}

class Person {
  public String name;

  public Person(String name) {
    this.name = name;
  }

  public Person() {}

  @Override
  public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            '}';
  }
}

class Student extends Person {
  public Student() {
    this.name = "stu";
  }
}

class Teacher extends Person {
  public Teacher() {
    this.name = "";
  }
}
```

### 所有类型的Class类对象
```java
/*
  所有类型的Class类对象：
    1.类加载完成后，系统就会在堆内存中产生该类的Class类型对象，仅系统可创建 && 仅能创建一次
    2.类、接口、注解等都有Class类对象 -> 实际只要是类，类加载的时候就会自动创建类对象
*/
package com.mi.reflect;

import java.lang.annotation.ElementType;

public class TestReflect2 {
  public static void main(String[] args) throws ClassNotFoundException {
    // 类加载完成后，系统就会在堆内存中产生该类的Class类型对象，仅系统可创建 && 仅能创建一次
    Class c1 = Class.forName("com.mi.reflect.Student");
    Class c2 = Class.forName("com.mi.reflect.Student");
    Class c3 = Class.forName("com.mi.reflect.Student");
    System.out.println(c1.hashCode());//
    System.out.println(c2.hashCode());//
    System.out.println(c3.hashCode());//

    // 类、接口、注解等都有Class类对象
    Class c4 = Object.class;// 类
    Class c5 = Comparable.class;// 接口
    Class c6 = String[].class;;// 数组
    Class c7 = int[][].class;// 二维数组
    Class c8 = Override.class; //注解
    Class c9 = ElementType.class;//枚举
    Class c10 = Integer.class;// 包装类
    Class c11 = void.class;// void -> 空类型
    Class c12 = Class.class;// Class类
    // 只要元素类型与维度一致就是同一个class -> 维度不同、类型不同就不是同class类对象
    int[] a = new int[10];
    int[] b = new int[100];
    System.out.println(a.getClass().hashCode());
    System.out.println(b.getClass().hashCode());
  }
}
```

### 获取类对象运行时的内部结构
```java
/*
  获取类对象运行时的内部结构：
    -> 实际类对象本质也是对象，操作属性、方法就会很便捷
    包名、类名、属性、方法等
*/
package com.mi.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect3 {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
    Class c1 = Class.forName("com.mi.reflect.User");

    // 包名
    System.out.println(c1.getName());

    // 类名
    System.out.println(c1.getSimpleName());

    // 获取属性
    // public属性
    Field[] fields = c1.getFields();
    for(Field field: fields) {
        System.out.println(field);
    }
    // 全部属性
    Field[] declaredFields = c1.getDeclaredFields();
    for(Field field: declaredFields) {
        System.out.println(field);
    }
    // 获取具体属性
    Field name = c1.getDeclaredField("name");
    System.out.println(name);

    // 获取方法
    // 类以及父类public方法
    Method[] methods = c1.getMethods();
    for(Method method: methods) {
        System.out.println(method);
    }
    // 类方法
    Method[] methods1 = c1.getDeclaredMethods();
    for(Method method: methods1) {
        System.out.println(method);
    }
    // 获取具体方法
    Method name1 = c1.getMethod("getName",null);
    System.out.println(name1);
    Method name2 = c1.getMethod("setName",String.class);
    System.out.println(name2);

    // 获取构造器
    // 获取public构造器
    Constructor[] constructors = c1.getConstructors();
    for(Constructor constructor: constructors) {
        System.out.println(constructor);
    }
    // 获取所有构造器方法
    Constructor[] constructors1 = c1.getDeclaredConstructors();
    for(Constructor constructor: constructors1) {
        System.out.println(constructor);
    }
    // 获取具体构造器
    Constructor construct = c1.getDeclaredConstructor(String.class,int.class,int.class);
    System.out.println(construct);
  }
}

// 实体类 pojo entity
class User {
  private String name;
  private int id;
  private int age;

  public User(String name, int id, int age) {
    this.name = name;
    this.id = id;
    this.age = age;
  }

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
### 动态创建对象操作属性方法
```java
/*
  动态创建对象执行方法
*/
package com.mi.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect4 {
  public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
    Class c1 = Class.forName("com.mi.reflect.User");

    // 构造对象：默认调用无参构造器
    User user = (User)c1.newInstance();
    System.out.println(user);
    // 构造对象：调用有参构造器
    Constructor constructor = c1.getConstructor(String.class,int.class,int.class);
    User user1 = (User)constructor.newInstance("a",1,1);
    System.out.println(user1);

    // 调用方法
    Method setName = c1.getDeclaredMethod("setName",String.class);
    setName.invoke(user,"a");// invoke:激活 -> invoke(对象，参数)
    System.out.println(user.getName());

    // 操作属性
    Field name = c1.getDeclaredField("name");
    name.setAccessible(true);//状态监测关掉，关掉才可操作私有属性 -> true:关掉、false:开启
    name.set(user,"b");
  }
}
```
### 静态语言 VS 动态语言
> 静态语言：强类型语言，运行时结构不可变[例如：变量类型确定后不可更改]，JAVA、C、C++ -> JAVA可利用反射机制实现'动态性'，其是'准动态语言'
> 动态语言：弱类型语言，运行时结构可变[例如：变量类型确定后可随意赋值修改，新的函数、对象甚至代码可被引进] -> JavaScript、PHP、Python、C#、Object-C