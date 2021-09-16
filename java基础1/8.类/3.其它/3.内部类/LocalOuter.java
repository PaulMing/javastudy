/**
 * 局部内部类：方法、构造器、代码块
 */
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
  };

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