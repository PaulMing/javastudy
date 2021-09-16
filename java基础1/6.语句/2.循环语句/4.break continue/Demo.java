/**
 * break
 */
public class Demo {
  public static void main(String[] args) {
    int i = 1;
    int j = 1;
    for(;i<=5;i++) {
      for(;j<=5;j++) {
        if(j==3) {
          break;
        }
        System.out.println("number");//输出两次
      }
    }
    System.out.println(i);//6
    System.out.println(j);//3
  }
}