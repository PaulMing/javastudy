/**
 * 模拟班级同学每周调换位置
 * array {{1,2,3},{4,5,6,7},{8,9,10,11,12},{13,14,15,16,17,18}}
 */
import java.util.Scanner;
public class Demo1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("请输入第几周：number");
    int week = input.nextInt();

    int[][] array = new int[][]{{1,2,3},{4,5,6,7},{8,9,10,11,12},{13,14,15,16,17,18}};
    int len = array.length;

    for(int i=0; i<week; i++) {
      // int[] temp = array[0];
      // array[0] = array[1];
      // array[1] = array[2];
      // array[2] = array[3];
      // array[3] = temp;
      int[] temp = array[len-4];
      array[len-4] = array[len-3];
      array[len-3] = array[len-2];
      array[len-2] = array[len-1];
      array[len-1] = temp;
    }
    
    // 遍历查看
    for(int[] item: array) {
      for(int value: item) {
        System.out.print(value + "\t");
      }
      System.out.println();
    }
  }
}