/**
 * 输出多行*
 */
import java.util.Scanner;
public class Demo1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("请输入行数：");
    int line = input.nextInt();
    System.out.print("请输入每行*的个数：");
    int count = input.nextInt();

    for(int i=1; i<=line; i++) {
      // 每行
      for(int j=1; j<=count; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}