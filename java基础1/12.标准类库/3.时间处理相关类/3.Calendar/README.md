## Calendar类
> Calendar是抽象类，GregorianCalendar子类来具体实现 -> java.util.GregorianCalendar
> 功能：提供日期计算相关功能，年、月、日、时、分、秒等
```java
// 日期对象
GregorianCalendar calendar1 = new GregorianCalendar(2021,8,8,11,13,14);
int year = calendar1.get(Calendar.YEAR);
int month = calendar1.get(Calendar.MONTH);//0~11
int day = calendar1.get(Calendar.DAY_OF_MONTH);
int day1 = calendar1.get(Calendar.DATE);//其等同于DAY_OF_MONTH
int date = calendar1.get(Calendar.DAY_OF_WEEK);//周日~周一 -> 1~7


GregorianCalendar calendar2 = new GregorianCalendar();
calendar2.set(Calendar.YEAR,2021);
calendar2.set(Calendar.MONTH,Calendar.FEBRUARY);
calendar2.set(Calendar.DATE,3);
calendar2.set(Calendar.HOUR_OF_DAY,10);
calendar2.set(Calendar.MINUTE,20);
calendar2.set(Calendar.SECOND,23);


// 日期计算
GregorianCalendar calendar3 = new GregorianCalendar(2021,8,8,11,13,14);
calendar3.add(Calendar.MONTH,-7);//月份减7
calendar3.add(Calendar.DATE,7);//天数加7


// 日期对象和时间对象转化
Date date1 = calendar3.getTime();
GregorianCalendar calendar4 = new GregorianCalendar();
calendar4.setTime(new Date());
```