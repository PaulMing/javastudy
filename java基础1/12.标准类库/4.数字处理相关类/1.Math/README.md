## Math类
> java.lang.Math -> 无需导包
> Math类库提供了系列静态方法用于科学计算，方法的参数返回值类型大多都是double类型

### 常用方法
```java
// 常量
System.out.println(Math.PI);//3.141592653589793
System.out.println(Math.E);

// 方法
System.out.println(Math.floor(3.6));//3.0 -> 向下取整
System.out.println(Math.ceil(3.2));//4.0 -> 向上取整
System.out.println(Math.round(3.6));//4 -> 四舍五入

System.out.println(Math.abs(-12));//12 -> 取绝对值
System.out.println(Math.sqrt(64));//8.0 -> 开方
System.out.println(Math.pow(2,3));//8.0 -> 2的3次方

System.out.println(Math.random());//[0,1)
```

### Math类底层
> 1. Math类不能创建对象，构造器私有化使用了private修饰
```java
private Math() {};//构造器私有后，外界无法方法
```
> 2. 类中的属性、方法均使用static修饰，仅能通过类名.属性/方法形式调用，因为不能创建对象，所以也不能通过对象.属性/方法调用
> 3. 类、属性、方法均使用final修饰，该类不能被继承，Math类中属性、方法的final修饰符可省略不写，因为不能被继承，方法也不可被重写
```java
public final class Math {}
```