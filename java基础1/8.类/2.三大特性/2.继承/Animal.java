public class Animal {
  public String name;
  public int age;

  public void shout() {
    System.out.println("shout")
  }

  public Animal() {};

  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }
}