## 字符串相关类
> String：不可变字符序列
> StringBuffer: 可变字符序列，线程安全，效率低[做线程同步检查] -> JDK1.0
> StringBuilder: 可变字符序列，线程不安全，效率高[不做线程同步检查]，建议使用 -> JDK1.5
> StringBuffer/StringBuilder均是抽象类AbstractStringBuilder的子类，它们的API一样

### 内存占用
> String类：不可变字符序列，多次执行改变字符串内容的操作会导致'创建大量副本对象'，占用大量内存
> StringBuffer/StringBuilder类：可变字符序列，多次执行改变字符串内容的操作依旧操作原对象，占用内存少
```java
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
```