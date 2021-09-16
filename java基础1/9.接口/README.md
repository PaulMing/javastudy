## 接口
> 其定义规则，具备强约束性 -> 实际也是'强类型语言'的体现
> 主要分为两个版本/写法：JDK1.8之前、JDK1.8之后

### JDK1.8之前
```java
/*
  接口中仅能写常量、抽象方法：
    常量：固定修饰符 public static final
    抽象方法：固定修饰符 public abstract
    -> 修饰符可省略不写，IDE会自动补全

    [访问修饰符] interface 接口名(大驼峰) [extends 父接口1, 父接口2,,,,,] {
      常量定义
      抽象方法
    }

  类实现接口：
    1.必须重写接口中的全部抽象方法，如果不想重写所有抽象方法，那么此类可以变成一个抽象类
    2.类仅能单继承，但有多实现 -> 可实现多个接口
      class Student implements interface1,interface2 {}
    3.类同时继承和实现接口，需要先继承、再实现：
      class Student extends Person implements interface1,interface2 {}
*/
public interface TestInterface1 {
  // 常量
  /*public static final*/int value = 10;
  // 抽象方法
  /*public abstracet*/ void deal();
  void deal1(int num);
}

public interface TestInterface2 {
  void deal2();
  void deal3(String value);
}

class Student implements TestInterface1, TestInterface2 {
  @override
  public void deal() {};

  @override
  public void deal1(int num) {};

  @override
  public void deal2() {};

  @override
  public void deal3(String value) {};
}

class Demo {
  public static void main(String[] args) {
    // 接口不能创建对象
    // TestInterface1 t = new TestInterface1();//错误
    TestInterface1 t = new Student();//接口指向实现类 -> 多态
    /*
      接口中如何访问常量：
        1.TestInterface1.value
        2.Student.value
        3.Student s = new Student(); s.value
        4.TestInterface1 s1 = new Student(); s1.value;
    */ 
  }
}
```

### JDK1.8之后
```java
/*
  接口：常量、抽象方法、非抽象方法、静态方法
    常量：固定修饰符 public static final -> 修饰符可省略不写，IDE会自动补全
    抽象方法：固定修饰符 public abstract -> 修饰符可省略不写，IDE会自动补全
    非抽象方法：
      1.public default 方法名 -> default修饰符不能省略
      2.实现类可重写该方法，重写时default修饰符不能有
    静态方法：
      1.static修饰符不能省略
      2.静态方法不能重写 -> 实现类可以拥有同名方法，等同于是'自己定义的方法'
    => 新增非抽象方法、静态方法的原因：若接口中仅能定义常量、抽象方法，每次修改接口内容[实际大多为修改抽象方法]，实现类都必须实现该抽象方法，所有实现类都需要修改，成本很大，添加非抽象方法、静态方法可以更灵活处理，代码扩展性更好
    
    [访问修饰符] interface 接口名(大驼峰) [extends 父接口1, 父接口2,,,,,] {
      常量定义
      抽象方法
      非抽象方法
      静态方法
    }

  类实现接口：
    类必须重写抽象方法，其它不强制
*/
public interface TestInterface1 {
  // 常量
  /*public static final*/int value = 10;
  // 抽象方法
  /*public abstracet*/ void deal();

  // 非抽象方法
  public default void deal1() {};

  // 静态方法
  public static void deal2() {
    System.out.println("接口中的抽象方法")
  };
}
class Student implements TestInterface1 {
  @override
  public void deal() {};

  @override
  public void deal1() {};

  // 静态方法 -> 非重写
  public static void deal2() {
    System.out.println("类中的抽象方法")
  };
}

class Demo {
  public static void main(String[] args) {
    Student s = new Student();
    s.deal2();
    Student.deal2();
    TestInterface1.deal2();
  }
}
```
### 补充
> 实际接口中可定义'内部接口'，等同于类中的内部类
> 可参考Map接口中的Entry内部接口

### 接口 vs 类
> 接口：
> 1. 其聚焦定义规则，类负责实现即可 -> 根据接口能很清楚的知道实现类具备的功能，后续代码扩展维护更简单
> 2. 其不是类，不能创建对象，但有继承概念 -> 其没有构造器、代码块等类的组成部分，实际其和类是'平级'

> 开发中使用接口还是类?
> 接口：has-a 的包含关系 -> 手机 implements 拍照 [手机有拍照能力]
> 类：is-a 的'是'关系 -> 手机 extends 机器 [手机是机器] 

> 多态的应用：
> 类：
> 1. 父类作为方法的形参，传入具体子类对象
> 2. 父类作为方法的返回值，返回具体子类对象
> -> 某类作为某类的属性
> 接口：
> 1. 接口作为方法的形参，传入具体实现类的对象
> 2. 接口作为方法的返回值，返回具体实现类的对象