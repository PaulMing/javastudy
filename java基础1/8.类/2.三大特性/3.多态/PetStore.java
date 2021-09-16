/**
 * 宠物店工厂类
 */
public class PetStore {
  public static Animal getAnimal(String petName) {
    Animal an = null;

    // petName.equals("猫");//写法不好，若petName为null,容易出现空指针异常
    if("猫".equals(petName)) {
      an = new Cat();
    }

    if("狗".equals(petName)) {
      an = new Dog();
    }

    if("猪".equals(petName)) {
      an = new Pig();
    }

    return an;
  }
}

class Test {
  public static void main(String[] args) {
    Person person = new Person();
    Animal an = PetStore.getAnimal("猪");
    person.play(an);
  }
}