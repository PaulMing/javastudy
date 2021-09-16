import java.util.Scanner;

public class Demo {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("请输入数组长度");
    int length = input.nextInt();

    int[] array = new int[6];
    // System.out.println(array);//hashcode
    // 存值
    for(int i=0; i<length; i++) {
      array[i] = i+1;
    }

    // 取值
    for(int i:array) {
      System.out.println("取值：" + i);
    }
  }
}