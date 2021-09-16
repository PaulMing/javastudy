/**
 * 自定义异常：大多包含两个构造器，默认、带参
 */
class IllegalAgeException extends Exception {
  // 默认构造器
  public IllegalAgeException() {}

  // 带参构造器
  public IllegalAgeException(String message) {
    super(message);
  }
}
class Person {
  private String name;
  private int age;
  public void setName(String name) {
    this.name = name;
  }
  public void setAge(int age) throws IllegalAgeException {
    if (age < 0) {
      throw new IllegalAgeException("人的年龄不应该为负数");
    }
    this.age = age;
  }
  public String toString() {
    return "name is " + name + " and age is " + age;
  }
}

public class Demo {
  public static void main(String[] args) {
    Person p = new Person();
    try {
      p.setName("Lincoln");
      p.setAge(-1);
    } catch (IllegalAgeException e) {
      e.printStackTrace();
    }
    System.out.println(p);
  }
}