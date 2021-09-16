## Date类
> java.uitl.Date -> 使用时需导包
```java
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
System.out.println(d.toString());//Sat Jul 10 10:39:58 CST 2021
```