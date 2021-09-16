import java.util.Random;
public class Demo {
  public static void main(String[] args) {
    // 枚举遍历
    for(Week k: Week.values()) {
      System.out.println(k);
    }

    // switch语句中使用枚举
    int a = new Random().nextInt(4);
    switch(Season.values()[a]) {
      case SPRING:
        System.out.println("spring");
        break;
      case SUMMER:
        System.out.println("summer");
        break;
      case AUTUMN:
        System.out.println("autumn");
        break;
      case WINTER:
        System.out.println("winter");
        break;
      default:
        System.out.println("error");
    }
  }
}

/*
  枚举：
    枚举本质是类，因此需要定义在外部
    枚举定义：
        enum 枚举名{
          枚举体（常量列表）
        }
*/
// 季节
enum Season {
  SPRING,
  SUMMER,
  AUTUMN,
  WINTER
}

// 星期
enum Week {
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY,
  SUNDAY
}