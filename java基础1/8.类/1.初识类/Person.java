public class Person {
  public String name;
  public int age;
  public String sex;

  /*
    关于this：
      -> 其指的就是最终创建的对象，方法中可通过其调用属性、方法
      1.this修饰属性：同一个类中可直接调用，this.可省略不写
      2.this修饰方法：同一个类中可互相调用，this.可省略不写
      3.this修饰构造器：
          同一个类中的构造器可相互使用this调用，但必须放在第一行
          this();//等同于this.Person(); 调用构造器简写
      => 开发中不建议this.省略，省略的本质也是编译过程中JVM默认识别为添加'this.'
  */
  public static void speak(){
    System.out.println(age);//this.age
    System.out.println(this.name + "speak");
  }
  public static void sport(){
    speak();//this.speak();
  }

  public Person() {

  }
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Person(String name, int age, String sex) {
    this(name,age);//this.Person(name,age)
    this.sex = sex;
    this.speak();
  }


  /*
    关于static:
      -> 背景：创建的实体拥有'共同的'属性/方法，每次都需要独立分配内存，于是将公共的属性方法使用static修饰将其存储在'方法区'，所有实体共用即可 => 类加载的时候就会将静态内容加载到方法区中的'静态域'，因此静态内容先于对象存在，被所有对象共享
      -> 优点：共用内存空间，减少内存浪费
      -> 缺点：如果将很多属性方法都使用static修饰，类初始时加载成本较高，内存占用也多[例如：创建少量实体却将很多属性方法都放到方法区，就很不划算]

      1.其可修饰：属性[也称为类变量]、方法[也称为类方法]、代码块、内部类
      2.访问方式：对象名.属性名/方法名; 类名.属性名/方法名(推荐) 
  */
  static String school;
  public static void record() {}
}