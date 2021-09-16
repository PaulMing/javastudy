/**
 * 输出  ***1***
 *       **121**   
 *       *12321*   
 *       1234321
 */
import java.util.Scanner;
public class Demo9 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("请输入行数：");
    int line = input.nextInt();

    for(int i=1; i<=line; i++) {
      // 每行
      // 左*符
      for(int j=1; j<=(line-i); j++) {
        System.out.print("*");
      }

      // 数字区
      // 左数字区
      for(int m=1; m<i; m++) {
        System.out.print(m);
      }
      // 中间区
      System.out.print(i);
      // 右数字区
      for(int n=i-1; n>=1; n--) {
        System.out.print(n);
      }

      // 右*符
      for(int j=1; j<=(line-i); j++) {
        System.out.print("*");
      }

      // 换行
      System.out.println();
    }
  }
}

/*
  分析思路：
      -> 每行都是由数字、*构成，因此分开讨论即可，数字又可分为左数字区、中间区、右数字区，当我们将*符号去掉，其就是一个数字组成的正三角形
                       *   数字区    左*   右*
         ***$***  i=1  7    1        3     3
         **$$$**  i=2  6    3        2     2
         *$$$$$*  i=3  4    5        1     1
         $$$$$$$  i=4  2    7        0     0
                          2i-1      line-i line-i


                       *            数字区                    左*   右*
                            左数字区 中间区 右数字区              
         ***1***  i=1  7      1->i    i     i->1              3     3
         **121**  i=2  6      1->i    i     1->i              2     2
         *12321*  i=3  4      1->i    i     1->i              1     1
         1234321  i=4  2      1->i    i     1->i              0     0
                                    21-1                   line-i  line-i
*/