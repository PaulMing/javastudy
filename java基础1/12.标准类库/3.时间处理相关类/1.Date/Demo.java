import java.util.Date;

public class Demo {
  public static void main(String[] args) {
    // 开发中使用long类型定义变量，其数据范围可表示基准时间往前几亿年、往后几亿年
    long range = Long.MAX_VALUE/(1000L*3600*24*365);
    System.out.println(range);//292471208 -> 2.9亿年

    long now = System.currentTimeMillis();//时间戳
    System.out.println(now);//1625824819229


    /*
      Date类：
        new Date();//返回当前时间对象
        new Date(long date);//返回date对应的时间对象
        long getTime();//返回时间戳
        String toString();//转换为String格式 -> dow mon dd hh:mm:ss zzz yyyy dow就是周中某天[Sun、Mon、Tue、Wed、Thu、Fri、Sat]
        
        -> JDK1.1之前的Date类提供了很多方法：日期操作、字符串转换成时间对象等，目前都废弃了，JDK1.1之后提供了日期操作类Calendar，字符串转化使用DateFormat类
    */ 
    Date d = new Date();
    Date d1 = new Date(1000L * 3600 * 24 * 365 * 150);
    System.out.println(d);//Sat Jul 10 10:39:58 CST 2021
    System.out.println(d.getTime());//1625884798100
    System.out.println(d.toString());//Sat Jul 10 10:39:58 CST 202
  }
}