## lamda表达式/lambda -> JDK1.8
> 其就是语法糖，简洁代码[保留核心逻辑代码，丢掉无意义代码] -> 仅简化匿名内部类，而且还是基于'函数式接口'的实现类
> 函数式接口: 接口中仅包含一个抽象方法，实际也是函数式编程范畴

```java
package com.mi.lamda;

public class TestLamda {
  // 静态内部类
  static class Like1 implements ILike {
    @Override
    public void lamda(int a) {
      System.out.println("lamda1" + a);
    }
  }

  public static void main(String[] args) {
    ILike ilike = new Like();
    ilike.lamda(0);

    ILike ilike1 = new Like1();
    ilike1.lamda(1);

    // 局部内部类
    class Like2 implements ILike {
      @Override
      public void lamda(int a) {
        System.out.println("lamda2" + a);
      }
    };
    ILike ilike2 = new Like2();
    ilike2.lamda(2);

    // 匿名内部类：无类的名称，必须借助接口或父类
    ILike like3 = new ILike() {
      @Override
      public void lamda(int a) {
        System.out.println("lamda3" + a);
      }
    };
    like3.lamda(3);

    /*
      lamda表达式：
        -> 其直接进行简化匿名内部类：仅关注参数、函数体
        ILike like4 = (int a) -> {
          System.out.println("lamda4" + 4);
        };

        -> 参数：
            1.若仅有一个参数，可省略小括号，多个参数or无参数，均不可省略
            2.参数类型：可省略参数类型，但要不写都不写，不要某个参数写某个参数不写
            ILike like4 = a -> {
              System.out.println("lamda4" + 4);
            };

        -> 函数体：
            若函数体内仅有一条语句，可省略外面的大括号
            ILike like4 = a -> System.out.println("lamda4" + 4);
    */
    ILike like4 = a -> System.out.println("lamda4" + 4);
    like4.lamda(4);
  }
}

// 接口
interface ILike {
  void lamda(int a);
}

// 实现类
class Like implements ILike {
  @Override
  public void lamda(int a) {
    System.out.println("lamda" + a);
  }
}
```