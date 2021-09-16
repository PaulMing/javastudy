/**
 * 输出右直角三角形：  $$$*   
 *                   $$**   
 *                   $***   
 *                   ****   
 */
import java.util.Scanner;
public class Demo1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("请输入行数：");
    int line = input.nextInt();

    for(int i=1; i<=line; i++) {
      // 每行
      // $符
      for(int j=1; j<=(line-i); j++) {
        System.out.print("$");
      }

      // *符
      for(int k=1; k<=i; k++) {
        System.out.print("*");
      }

      // 换行
      System.out.println();
    }
  }
}
/*
  分析思路：
      -> 每行都是由$、*构成，因此分开讨论即可，当我们将$替换为空时，就可以描绘出"右直角三角形"
                     $      *
      $$$*   i=1     3      1
      $$**   i=2     2      2
      $***   i=3     1      3
      ****   i=4     0      4
                   line-i   i
*/