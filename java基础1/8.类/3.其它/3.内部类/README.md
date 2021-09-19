## 内部类
> 背景：java支持类中书写类，例如某些类仅使用一次，使用内部类就很合适，但开发中使用场景很少
> 内部类：成员内部类[类中，静态、非静态]、局部内部类[方法、构造器、代码块]、匿名内部类[简洁写法,语法糖] => 聚焦点：内部类终究也是类，属性、方法、构造器、各种修饰符等均可以使用 -> 难点：内部类与外部类属性、方法互相访问操作

### 成员内部类
> 内部类作为外部类的成员
```java
public class MemberOuter {
  int value = 10;
  public void deal() {
    System.out.println("deal");
  };
  public static void deal1() {
    System.out.println("deal1");
  };

  // 非静态成员内部类
  public class A {
    int value = 20;
    public void func() {
      // 内部类可访问外部类的内容
      deal();
      int value = 30;
      System.out.println(value);//30
      System.out.println(this.value);//20
      System.out.println(MemberOuter.this.value);//10
    }
  }

  // 静态成员内部类
  static class B {
    // 仅能访问外部类中的静态属性、静态方法
    deal1();
  }

  // 外部类访问内部类：创建内部类的对象后才能调用
  A a = new A();
  System.out.println(a.value);
  a.func();
}

class Test {
  public static void main(String[] args) {
    // 创建外部类对象
    MemberOuter outerObj = new MemberOuter();

    // 创建内部类对象
    // 非静态成员内部类
    MemberOuter outerObj = new MemberOuter();
    MemberOuter.A a = ouerObj.new A();//不能直接使用：MemberOuter.A a = new MemberOuter.A();
    // 静态成员内部类
    MemberOuter.B b = new MemberOuter.B();
  }
}
```

### 局部内部类
```java
public class LocalOuter {
  int value = 10;
  public void deal() {
    // 方法中的局部内部类
    class A {

    }
    System.out.println("deal");
  };

  public LocalOuter() {
    // 构造器中的局部内部类
    class B {}
  }

  // 代码块中的局部内部类
  {
    class C {}
  }

  // 局部内部类中访问到的变量必须是被final修饰
  public static void deal1() {
    final int count = 10;
    class D {
      public void d() {
        System.out.println(count)
      }
    }
  }

  // 和接口联用
  public ComInterface deal2() {
    class B implements ComInterface{
      @Override
      public int compareTo(Object o) {
        return 520;
      }
    }
    return new B();
  }

  public ComInterface deal3() {
    return new ComInterface() {
      @Override
      public int compareTo(Object o) {
        return 520;
      }
    }
  }
}

class Test {
  public static void main(String[] args) {
    // 创建外部类对象
    LocalOuter outerObj = new LocalOuter();
  }
}
```

### 匿名内部类
```java
public class Inner {
  public void deal() {
    // 匿名内部类：无类的名称，直接借助接口或父类完成对象的定义
    ILike like = new ILike() {
      @Override
      public void lamda() {
        System.out.println("lamda");
      }
    }
  }
}
// 定义接口 -> 后面会学
interface ILike() {
  void like()
}
```