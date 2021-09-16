/**
 * 基本使用
 */
public class Demo {
  public static void main(String[] args) {
    /*
      字符串定义：
        1.字面量：
          String s = "Hello";//底层调用new String("Hello");
        2.对象创建：
          String s = new String("Hello")
    */ 

    /*
      字符串连接：
        1.使用+号运算符可将字符串按顺序拼接在一起
        2.+号运算符两侧的操作数只要有一个是字符串类型，系统会自动将另一个操作数隐式转换为字符串然后进行拼接
    */
    String s1 = "Hello";
    String s2 = "World";
    String s3 = s1 +s2;//"HelloWorld"

    int count = 520;
    String s4 = "count值是：" + count;//"count值是520"

    /*
      字符串相等判断：
        equals();//String类进行了重写，其比较堆区中的值是否相等 -> Object类中的equals方法依旧判断栈区的地址/引用是否相等
    */
    String s1 = "hi";
    String s2 = "hi";
    System.out.println(s1 == s2);//true -> 它们指向同一地址
    System.out.println(s1.equals(s2));//true
    String s3 = new String("hi");
    System.out.println(s1 == s3);//false
    System.out.println(s1.equals(s3));//true
  }
}