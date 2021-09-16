/**
 * 循环标记
 */
public class Demo2 {
  public static void main(String[] args) {
    int i = 1;
    int j = 1;
    outer:for(;i<=5;i++) {
      inner:for(;j<=5;j++) {
        if(j==3) {
          break outer;
        }
        System.out.println("number");//输出两次
      }
    }
    System.out.println(i);//1
    System.out.println(j);//3
  }
}