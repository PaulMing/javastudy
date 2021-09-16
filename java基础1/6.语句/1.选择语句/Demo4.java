/**
 * 需求：使用switch判断学生成绩对应的区间
 * < 60: 不及格
 * 60~70：及格
 * 70~80：中
 * 80~90：良
 * 90~100：优秀
 * 100：满分
 * 其它：error -> 兜底方案
 * 
 * 解决方案：首先很容易想到使用if分支来解决，但需求需要使用switch分支解决 -> switch聚焦'值比对'，因此可先进行'预处理'，方便后面的值处理
 */
import java.util.Scanner;
public class Demo4 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("请输入成绩 ~");
    int score = input.nextInt();
    String result = "";

    switch(score/10) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
        result = "不及格";
        break;
      case 6:
        result = "及格";
        break;
      case 7:
        result = "中";
        break;
      case 8:
        result = "良";
        break;
      case 9:
        result = "优秀";
        break;
      case 10:
        result = "满分";
        break;
      default:
        result = "请正确输入成绩，成绩范围0~100";
    }
    System.out.println("成绩：" + result);
  }
}