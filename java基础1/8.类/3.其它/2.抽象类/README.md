## 抽象类
> 背景：很多类有共同属性方法，于是抽离出'父类' -> 抽象类是'强约束'的父类，类中包含属性、普通方法、抽象方法，该类不能创建对象，继承该类的子类必须实现父类中的抽象方法 => 抽象类目的就是定义模板，子类必须实现该模板提供的抽象方法

### 开发应用
> 1. 定义抽象类、抽象方法[抽象方法仅存在于抽象类，虽然其可写属性、普通方法，但抽象类中大多不写属性、普通方法]
> 2. 抽象类被继承：子类必须重写所有抽象方法，若不想重写所有抽象方法，只能将子类也变成一个抽象类[子类继承抽象类后并不是抽象类，抽象类目的就是提供'强模板']
> 3. 抽象类不能创建对象，但也有构造器 -> 构造器被private修饰，子类创建对象的时候也要先super调用父类构造器
> 4. 抽象类不能被final修饰，因为其目的就是被子类继承，重写父类方法
```java
// abstract public class Animal
public abstract class Animal {
  // 普通方法
  public void eat() {}

  // 抽象方法 -> 其没有方法体
  public abstract void shout();
  public abstract void run();
}

public class Cat extends Animal {
  public void shout() {
    System.out.println("喵喵");
  }
  public void run() {
    System.out.println("边跑边喵");
  }
}
```