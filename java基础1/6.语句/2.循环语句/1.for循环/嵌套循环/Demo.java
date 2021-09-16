/**
 * 根据用户输入个数，输出一行*
 */
import java.util.Scanner;
public class Demo {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("请输入*的个数：");
    int count = input.nextInt();

    for(int i=1; i<=count; i++) {
      System.out.print("*");
    }
  }
}