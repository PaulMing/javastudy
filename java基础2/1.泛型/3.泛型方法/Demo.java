/**
 * 泛型方法
 */
public class Demo {
  public static <T> void setFlag(T flag) {
    System.out.println(flag);
  }
  public static <T> T getFlag(T flag) {
    return flag;
  }

  public <T> void func(T...args) {
    for(T t:args) {
      System.out.println(t);
    }
  }

  public static void main(String[] args) {
    Demo.setFlag("HelloWorld");
    String[] arr = new String[]{"h","e","l","l","o"};
    Demo demo = new Demo();
    demo.func(arr);
    System.out.println(Demo.getFlag(123456));
  }
}