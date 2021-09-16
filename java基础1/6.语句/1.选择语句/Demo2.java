/**
 * 水仙花函数：百位数3次方 + 十位数3次方 + 个位数3次方 = 某3位数
 */
public class Demo2 {
  public static void main(String[] args) {
    for (int num = 100; num < 1000; num++) {
      int b = num/100;
      int s = num/10%10;//int s = num%100/10
      int g = num%10;
      if (b*b*b + s*s*s + g*g*g == num) {
        System.out.println("水仙花函数："+num);
      }

      // 优化：double value = Math.pow(double a, double b)
      // if (Math.pow(b,3) + Math.pow(s,3) + Math.pow(g,3) == num) {
      //   System.out.println("水仙花函数："+num)
      // }

      /*
        补充：
          Math是内部类，直接使用即可，不用引入，本质就是引入Math类 import java.lang.Math
          double value = Math.random();//[0.0,1.0)
          int num = (int)(value*6 + 1);//[1,6]
      */
    }
  }
}