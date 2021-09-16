/**
 * String类、StringBuilder类在字符串频繁修改时的效率测试
 */
public class Demo1 {
  public static void main(String[] args) {
    // String类
    String str = "";
    long freeMry1 = Runtime.getRuntime().freeMemory();
    long time1 = System.currentTimeMillis();
    for(int i=0; i<5000; i++) {
      str = str + i;
    }
    long freeMry2 = Runtime.getRuntime().freeMemory();
    long time2 = System.currentTimeMillis();
    System.out.println("String类占用内存：" + (freeMry1 - freeMry2));
    System.out.println("String类占用时间：" + (time2 - time1));

    // StringBuilder类
    StringBuilder strBud = new StringBuilder("");
    long freeMry3 = Runtime.getRuntime().freeMemory();
    long time3 = System.currentTimeMillis();
    for(int i=0; i<5000; i++) {
      strBud.append(i);
    }
    long freeMry4 = Runtime.getRuntime().freeMemory();
    long time4 = System.currentTimeMillis();
    System.out.println("StringBuilder类占用内存：" + (freeMry3 - freeMry4));
    System.out.println("StringBuilder类占用时间：" + (time4 - time3));
  }
}