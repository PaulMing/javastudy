/**
 * 两数交换
 */
public class Demo {
  public static void main(String[] args) {
    int a = 1;
    int b = 2;

    // 方式1 -> 缺点：声明了新变量，会占据内存空间
    // int c;
    // c = b;
    // b = a;
    // a = c;

    // 方式2 -> 缺点：加法减法操作可能导致值范围溢出
    // a = a + b;
    // b = a - b;
    // a = a - b;

    // 方式3 -> 此方法最佳，按位异或值范围变动较小
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;

    System.out.println(a);
    System.out.println(b);
  }
}