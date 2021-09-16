public class Demo {
  public static void main(String[] args) {
    // 常量
    System.out.println(Math.PI);//3.141592653589793
    System.out.println(Math.E);

    // 方法
    System.out.println(Math.floor(3.6));//3.0 -> 向下取整
    System.out.println(Math.ceil(3.2));//4.0 -> 向上取整
    System.out.println(Math.round(3.6));//4 -> 四舍五入

    System.out.println(Math.abs(-12));//12 -> 取绝对值
    System.out.println(Math.sqrt(64));//8.0 -> 开方
    System.out.println(Math.pow(2,3));//8.0 -> 2的3次方

    System.out.println(Math.random());//[0,1)
  }
}