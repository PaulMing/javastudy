/**
 * 根据输入返回星期值
 */
import java.util.Scanner;
public class Demo3 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("请输入一个数字，输出星期 ~");
    int num = input.nextInt();
    String week;

    switch(num) {
      case 1: 
        week = "Monday";
        break;
      case 2: 
        week = "Tuesday";
        break;
      case 3: 
        week = "Wednesday";
        break;
      case 4:
        week = "Thursday";
        break;
      case 5: 
        week = "Friday";
        break;
      case 6:
        week = "Saturday";
        break;
      case 7: 
        week = "Sunday";
        break;
      default:
        week = "error";
    };
    System.out.println(week);
  }
}