public class Person {
  private int age;

  // 读操作
  public int getAge() {
    return age;
  }

  // 写操作
  public void setAge(int age) {
    if(age < 0) {
      this.age = 0;
    } else if (age > 150) {
      this.age = 150;
    } else {
      this.age = age;
    }
  }
}