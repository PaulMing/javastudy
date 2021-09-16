## 多态
> 其表示多种状态，同一个行为，不同子类表现不同的状态 -> 代码层面：同一个方法调用，不同对象产生不同行为，多态是'方法'层面，与属性无关

> 优势：
> 提高了代码扩展性，尽量少的修改代码，通过方法参数提升代码灵活性 -> 符合面向对象设计原则：开闭原则[针对扩展是开放的，修改是关闭的]
> 多态可提高扩展性，但扩展性并没有达到最好，后续会学习'反射'

> 实现多态条件：
> 1. 存在继承关系 && 子类对父类重写方法
> 2. 父类应用指向子类对象 -> 可作为方法参数或返回值


### 向上转型/向下转型 -> 本质：引用数据类型间的转换，聚焦点就是类
> 向上转型：父类引用指向子类对象[小转大]       Animal an = pig;//Pig pig = new Pig();
> 向下转型：子类引用指向父类对象转换[大转小]   Pig pig = (Pig)an 
```java
public class Animal {
  int age = 2;
  public void shout() {
    System.out.println("shout");
  }
}
public class Pig extends Animal {
  double weight = 30;
  public void shout() {
    System.out.println("哼哼");
  }
  public void eat() {
    System.out.println("eat");
  }
}
public class Demo {
  public static void main(String[] args) {
    Pig p = new Pig();
    Animal an = p;
    an.shout();
    an.age = 6;
    // an虽然和p的地址相同，指向相同的堆内存空间，但是an仅能调用Animal类的属性方法，不能调用Pig类属性方法 -> 底层就是编译期、运行期导致的，an仅能'看到'Animal类中的内容 -> 解决方案：向下转型
    // an.eat();//报错
    // an.weight = 20;//报错

    Pig pig = (Pig)an;
    pig.eat();
    pig.weight = 20;
    pig.age = 8;
  }
}
```

### 简单工厂设计模式
> 背景：涉及到大量对象创建的项目，对象创建、使用会让代码阅读性较差 -> 工厂设计模式：对象创建和使用分开处理，工厂负责创建对象，本质就是'封装函数，入参出参，让调用形式变简单'
> 实现要求：
> 1. 传入简单的字符串类型参数，工厂根据参数创建子类产品然后返回，返回值类型是父类类型
> 2. 工厂类中的方法应该使用'静态方法'，直接通过类名调用 -> 调用形式更加清晰
```java
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
```