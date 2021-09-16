## 泛型 -> 数据类型的参数化[仅限引用类型]，JDK1.5新增
> 背景：开发中当参数类型不确定时，使用Object类型实现任意参数类型[多态,Object是祖先类]，方法内进行类型判断以完成相应操作，若不进行类型判断，很容易出现'类型自动转换'从而出错，而且编译期无法识别到这些错误，运行期才会发现 => 泛型：1.代码可读性更好[无需类型判断]; 2.程序更加安全[其会在编译期间进行类型处理(类型擦除)，类型错误会在编译期报出，运行期间不会出现异常]
> 类型擦除：编译器编译过程中会将泛型转换为普通的数据类型，类型参数编译后会被替换成Object，编译后的字节码class文件并不包含泛型中的类型信息，也就是泛型仅用于编译阶段

### 泛型定义
> 其可使用任何标识符，但开发中建议使用E、T、K、V、N、? -> 见名知意[开发者都认识]
> E  Element  容器中使用，表示容器中的元素
> T  Type     表示普通的JAVA类
> K  Key      表示键、Map中的键Key
> V  Value    表示值
> N  Number   表示数值类型
> ?  xxx      表示不确定的JAVA类型

### 泛型使用
> 泛型分类：泛型类、泛型接口、泛型方法 -> 泛型就是将类型当作参数传入，因此有参数的地方都可使用泛型

#### 泛型类
> 类名定义：添加一个或多个类型参数声明：<T>、<T,K,V>
> 创建对象时进行传入
```java
// public class 类名<泛型表示符号> {}

public class Generic<T> {
  private T flag;
  public void setFlag(T flag) {
    this.flag = flag
  }
  public T getFlag() {
    return this.flag
  }
}

public class Demo {
  public static void main(String[] args) {
    Generic<String> generic = new Generic<>();
    generic.setFlag("HelloWorld");
    System.out.println(generic.getFlag());

    Generic<Integer> generic1 = new Generic<>();
    generic1.setFlag(10);
    System.out.println(generic1.getFlag());
  }
}
```

#### 泛型接口
> 接口名后添加一个或多个类型参数声明：<T>、<T,K,V>
> 实现类中进行传入
```java
// public interface 接口名<泛型表示符号> {}

public interface Igeneric<T> {
  T getName(T name);
}
// 实现类
public class IgenericImp implements Igeneric<String> {
  @override
  public String getName(String name) {
    return name;
  }
}

public class Demo {
  public static void main(String[] args) {
    IgenericImp igenericImp = new IgenericImp();
    String name = igenericImp.getName();
    System.out.println(name);
  }
}
```

#### 泛型方法
> 背景：泛型类中定义的泛型，方法中也可使用，但某些场景仅需要在方法中使用泛型
> 方法参数、返回值可使用泛型，调用泛型方法时无需'显示传入类型'，编译器可自动推断出类型[类型推导]
```java
// 非静态方法
public <泛型表示符号> void getName(泛型表示符号 name) {};
public <泛型表示符号> 泛型表示符号 getName(泛型表示符号 name) {};
// 静态方法 -> 其无法访问类上定义的泛型，因此仅能使用泛型方法
public static <泛型表示符号> void setName(泛型表示符号 name) {};
public static <泛型表示符号> 泛型表示符号 getName(泛型表示符号 name) {};
// 其也可定义可变参数类型
public <泛型表示符号> void showMsg(泛型表示符号...args) {}

public class Demo {
  public static <T> void setFlag(T flag) {
    System.out.println(flag);
  }
  public static <T> T getFlag(T flag) {
    return flag;
  }
  public <T> void func(T...args) {
    for(T t:args) {
      System.out.println(t);
    }
  }

  public static void main(String[] args) {
    Demo.setFlag("HelloWorld");
    System.out.println(Demo.getFlag(123456));
  }
}
```

#### 通配符和上下限定符 -> 这些符号并不适用泛型类，场景用于类作为某个类中方法的参数[实际开发中会遇到，那时候你可体会到这些符号的美妙]
> 背景：某些情况具体类型不确定，可使用?表示任何类型，常用于函数参数为对象 -> 上下限定符就是设定边界而已
```java
// 无界通配符 -> 任意类型
public void showFlag(Generic<?> generic) {}
// 上限限定符 -> 当前类以及子类 || 当前接口以及子接口
public void showFlag(Generic<? extends Number> generic) {}
// 下限限定符 -> 当前类以及父类 || 当前接口以及父接口
public void showFlag(Generic<? super Integer> generic) {}
```