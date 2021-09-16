## final修饰符/关键字
> 其表示'最终的状态'，可修饰变量、方法、类

### 修饰变量
> 1. 修饰基本数据类型变量，修饰后变量值不可改变，实际就是变成了常量，变量名必须大写
> 2. 修饰引用数据类型变量，修饰后变量地址值不可改变，但变量中的值可改变，例如类中的属性依旧可改变
```java
public class Animal {
  public String name;
  public int age;

  public void shout() {
    System.out.println("shout")
  }
}

public class Test {
  public static void main(String[] args) {
    final int VALUE = 10;
    // VALUE = 20;//不可修改值

    final Animal animal = new Animal();
    // animal = new Animal();//修饰后的引用类型地址值不可改变
    animal.age = 6;//对象的属性值依旧可修改

    final Animal animal1 = new Animal();
    deal1(animal1);

    deal2(animal2);
  }
  
  // final修饰函数参数
  public static void deal1(Animal animal) {
    animal = new Animal();//可修改
  }

  public static void deal2(final Animal animal) {
    // animal = new Animal();//不可修改
  }
}
```

### 修饰方法
> 修饰后的方法不可以被重写 -> 主要修饰'继承关系'中父类的方法
```java
public class Animal {
  final public void shout() {
    System.out.println("shout")
  }
}

public class Cat extends Animal {
  // 子类不可重写shout
  // public void shout() {}
}
```

### 修饰类
> 修饰后的类不可以被继承，没有子类 -> 若类被final修饰，里面的方法若用final修饰可省略不写，因为不能被继承，也就不存在方法重写
```java
public final class Animal {
  /*final*/ public void shout() {
    System.out.println("shout")
  }
}

// 不能继承final修饰的类
public class Cat extends Animal {

}
```