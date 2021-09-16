## Random类
> java.util.Random -> 需要导包
> 背景：其就是用于生成随机数 -> Math.random()可生成[0,1)之间的随机数，但并不能很好的处理复杂需求，Math.random()底层调用Random类的nextDounble()方法

### 常用方法
```java
  Random rand = new Random();
  System.out.println(rand.nextInt());//随机生成int数据类型范围之内的整型数据
  System.out.println(rand.nextFloat());//[0,1)之间的float类型数据
  System.out.println(rand.nextDouble());//[0,1)之间的double类型数据
  System.out.println(rand.nextBoolean());//随机生成true、false

  // 随机生成[0,10)间的int类型数据
  System.out.println(rand.nextInt(10));
  // 随机生成[20,30)间的int类型数据
  System.out.println(20+rand.nextInt(10));
  System.out.println(20+(int)(rand.nextDouble() * 10));//此方法较复杂
```