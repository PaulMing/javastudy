/**
 * 输出左倒直角三角形：  ****   
 *                     ***$   
 *                     **$$   
 *                     *$$$ 
 */
import java.util.Scanner;
public class Demo3 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("请输入行数：");
    int line = input.nextInt();

    for(int i=1; i<=line; i++) {
      System.out.print("*");
    }
    System.out.println();
    for(int i=2; i<=line; i++) {
      // 每行
      // *符
      for(int j=1; j<=(line+1-i); j++) {
        System.out.print("*");
      }

      // $符
      for(int k=1; k<=i-1; k++) {
        System.out.print("$");
      }

      // 换行
      System.out.println();
    }
  }
}
/*
  分析思路：
      -> 每行都是由$、*构成，因此分开讨论即可，当我们将$替换为空时，就可以描绘出"左倒直角三角形"
                        *          $
        ****    i=1     4          0
        ***$    i=2     3          1
        **$$    i=3     2          2
        *$$$    i=4     1          3
                      (line+1)-i  i-1

      -> 除了上述方式，可以单独处理首行，然后从第二行循环即可
      for(int i=1; i<=line; i++) {
        System.out.print("*");
      }
      System.out.println();
      for(int i=2; i<=line; i++) {
        // 每行
        // *符
        for(int j=1; j<=(line+1-i); j++) {
          System.out.print("*");
        }

        // $符
        for(int k=1; k<=i-1; k++) {
          System.out.print("$");
        }

        // 换行
        System.out.println();
      }
*/