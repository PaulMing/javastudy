public class Demo {
  public static void main(String args[]) {
    // 装箱：基本数据类型 -> 包装类
    Integer n1 = Integer.valueOf(100);
    System.out.println(n1);

    // 拆箱：包装类 -> 基本数据类型
    Integer n2 = 100;
    int n3 = n2.intValue();
    System.out.println(n3);

    // 字符串转换成对象
    Integer n4 = Integer.parseInt("520");//Integer n = 520;
    System.out.println(n4);
    System.out.println(Integer.parseInt("520"));//520;

    // 对象转换成字符串
    String s1 = n4.toString();// String s1 = "520" -> 底层使用的new String()
    System.out.println(s1);


    /*
      包装类的缓存：  
        包装类提供的valueOf方法会对-128~127间的数进行缓存，目的是提高效率 -> 仅仅是整型、char类型的包装类

        public static Integer valueOf(int i) {
          if (i >= IntegerCache.low && i <= IntegerCache.high) {
            return IntegerCache.cache[i + (-IntegerCache.low)];
          }
          return new Integer(i);
        }
    */ 
    Integer n5 = 520;
    Integer n6 = 520;
    System.out.println(n5 == n6);//false
    System.out.println(n5.equals(n6));//true
    Integer n7 = -128;
    Integer n8 = -128;
    System.out.println(n7 == n8);//true
    System.out.println(n7 == n8);//true
  }
}