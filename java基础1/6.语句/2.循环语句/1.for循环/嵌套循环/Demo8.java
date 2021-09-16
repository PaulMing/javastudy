/**
 * 输出倒正三角形  $$$$$$$
 *                *$$$$$*   
 *                **$$$**   
 *                ***$***
 */
import java.util.Scanner;
public class Demo6 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("请输入行数：");
    int line = input.nextInt();

    for(int i=1; i<=line; i++) {
      // 每行
      // 左*符
      for(int j=1; j<=(i-1); j++) {
        System.out.print("*");
      }

      // $符
      for(int k=1; k<=2*(line-i)+1; k++) {
        System.out.print("$");
      }

      // 右*符
      for(int j=1; j<=(i-1); j++) {
        System.out.print("*");
      }

      // 换行
      System.out.println();
    }
  }
}

/*
  分析思路：
      -> 每行都是由$、*构成，因此分开讨论$/*即可，左*、$、右*，当我们将*替换为空时，就可以描绘出"倒正三角形"
                         *    $          左*      右*
         $$$$$$$  i=1    0    7          0        0
         *$$$$$*  i=2    2    5          1        1
         **$$$**  i=3    4    3          2        2
         ***$***  i=4    6    1          3        3
                          2*(line-i)+1  i-1      i-1
*/