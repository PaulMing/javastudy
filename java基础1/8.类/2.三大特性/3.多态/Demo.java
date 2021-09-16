/**
 * 主函数
 */
public class Demo {
  public static void main(String[] args) {
    Person person = new Person();

    // 和猫玩
    Cat cat = new Cat();
    person.play(cat);

    // 和狗玩
    Dog dog = new Dog();
    person.play(dog);

    // 和猪玩
    Pig pig = new Pig();
    person.play(pig);

    // 优化版 -> 使用多态：父类引用指向子类对象
    Animal an = pig;
    person.play(an)
  }
}