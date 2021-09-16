/**
 * 根据月份判断季节
 */
import java.util.Scanner;

public class Demo {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("请输入月份，系统将返回月份对应的季节 ~ ");
    int month = input.nextInt();//读取输入的数字; input.nextLine();//读取输入的字符串
    
    String season = "";
    if (month < 1 || month > 12) {
      System.out.println("请重新输入，月份范围值1~12");
    }
    if (month == 3 || month == 4 || month == 5) {
      season = "spring";
    } else if (month == 6 || month == 7 || month == 8) {
      season = "summer";
    } else if (month == 9 || month == 10 || month == 11) {
      season = "autumn";
    } else {
      season = "winter";
    } 
    // System.out.println("当前季节"+season)
    System.out.println(season);
  }
}