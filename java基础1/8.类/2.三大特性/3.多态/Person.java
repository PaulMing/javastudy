/**
 * Person类 -> 实现一个和'动物'玩的方法
 */
public class Person {
  // 和猫玩
  public void play(Cat cat) {
    cat.shout();
  }

  // 和狗玩
  public void play(Dog dog) {
    dog.shout();
  }

  // 和猪玩
  public void play(Pig pig) {
    pig.shout();
  }

  // 优化版 -> 使用多态，直接实现一个'和小动物玩'的方法
  public void play(Animal an) {
    an.shout();
  }
}
