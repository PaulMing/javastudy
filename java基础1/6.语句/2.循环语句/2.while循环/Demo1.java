/**
 * 输出  ***$***
 *       **$$$**   
 *       *$$$$$*   
 *       $$$$$$$
 */
import java.util.Scanner;
public class Demo1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("请输入行数：");
    int line = input.nextInt();

    int i = 1;
    while(i<=line) {
      // 每行

      // 左*符
      int j=1;
      while(j<=(line-i)) {
        System.out.print("*");
        j++;
      }

      // $符
      int m = 1;
      while(m<=(2*i-1)) {
        System.out.print("$");
        m++;
      }

      // 右*符
      int k=1;
      while(k<=(line-i)) {
        System.out.print("*");
        k++;
      }

      // 换行
      System.out.println();
      i++;
    }
  }
}
/*
  分析思路：
      -> 每行都是由$、*构成，因此分开讨论$/*即可，左*、$、右*，当我们将*替换为空时，就可以描绘出'正三角形'
                       *    $        左*   右*
         ***$***  i=1  7    1        3     3
         **$$$**  i=2  6    3        2     2
         *$$$$$*  i=3  4    5        1     1
         $$$$$$$  i=4  2    7        0     0
                          2i-1      line-i
*/