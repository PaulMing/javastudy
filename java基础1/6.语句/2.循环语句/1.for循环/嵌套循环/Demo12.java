/**
 * 输出九九乘法表
 *       1*1 = 1  
 *       1*2 = 2   2*2 = 4   
 *       1*3 = 3   2*3 = 6  3*3 = 9
 */
import java.util.Scanner;
public class Demo10 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("请输入行数：");//范围：1-9
    int line = input.nextInt();

    // 打印$、*
    // for(int i=1; i<=line; i++) {
    //   // 每行
    //   // 左侧区
    //   for(int j=1; j<=i; j++) {
    //     System.out.print("$");
    //   }

    //   // 右侧区
    //   for(int k=1; k<=(line-i); k++) {
    //     System.out.print("*");
    //   }

    //   // 换行
    //   System.out.println();
    // }


    // 打印$、*
    for(int i=1; i<=line; i++) {
      // 每行
      // 左侧区
      for(int j=1; j<=i; j++) {
        System.out.print(j + "*" + i + "=" + (j*i) + "\t");//tab键可智能空格大小，让输出平齐
      }

      // 右侧区
      for(int k=1; k<=(line-i); k++) {
        System.out.print(" ");
      }

      // 换行
      System.out.println();
    }
  }
}

/*
  分析思路：
      -> 每行都是由数字、空格构成，因此分开讨论即可
                             $      *
         $***       i=1      1      3
         $$**       i=2      2      2
         $$$*       i=3      3      1
         $$$$       i=4      4      0
                             i     line-i


                                                数字区              *
         1*1 = 1                       i=1      1*1                2
         1*2 = 2   2*2 = 4             i=2      1*2                1
         1*3 = 3   2*3 = 6  3*3 = 9    i=3      1*3                0
                                                j*i               line-i
*/