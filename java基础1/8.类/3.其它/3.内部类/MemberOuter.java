/**
 * 成员内部类
 */
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