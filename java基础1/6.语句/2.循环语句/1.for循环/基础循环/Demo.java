public class Demo {
  public static void main(String[] args) {
    for(int i=0; i<=10; i++) {
      System.out.println(i);
    }
    // System.out.println(i);//报错，找不到变量i -> 原因：变量的生命周期，声明时创建，用完即刻回收，变量i的生命周期仅存在于for循环

    int j = 0;
    for(; j<=10; j++) {
      System.out.println(j);
    }
    System.out.println(j);
  }
}