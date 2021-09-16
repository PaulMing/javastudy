/**
 * 输出左右直角三角形  $$$$$$$
 *                   *$$$$$*   
 *                   **$$$**   
 *                   ***$***
 */
import java.util.Scanner;
public class Demo7 {
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
        System.out.print(" ");
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
      -> 中间$区域设为空即可描述"左右直角三角形"
                         *    $          左*      右*
         $$$$$$$  i=1    0    7          0        0
         *$$$$$*  i=2    2    5          1        1
         **$$$**  i=3    4    3          2        2
         ***$***  i=4    6    1          3        3
                          2*(line-i)+1  i-1      i-1
*/