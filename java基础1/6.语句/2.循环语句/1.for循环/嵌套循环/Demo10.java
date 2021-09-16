/**
 * 输出菱形    ***$***
 *            **$$$**   
 *            *$$$$$*   
 *            $$$$$$$
 *            *$$$$$*
 *            **$$$**
 *            ***$***
 */
import java.util.Scanner;
public class Demo8 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("请输入行数：");
    int line = input.nextInt();
 
    // 上半部分
    for(int i=1; i<=line; i++) {
      // 每行
      // 左*符
      for(int j=1; j<=(line-i); j++) {
        System.out.print("*");
      }

      // $符
      for(int k=1; k<=(2*i-1); k++) {
        System.out.print("$");
      }

      // 右*符
      for(int j=1; j<=(line-i); j++) {
        System.out.print("*");
      }

      // 换行
      System.out.println();
    }

    // 下半部分 -> 从第二行开始即可
    for(int i=2; i<=line; i++) {
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
      -> 结合"正三角形"、"倒三角形"，进行拼接便可描绘出菱形
*/