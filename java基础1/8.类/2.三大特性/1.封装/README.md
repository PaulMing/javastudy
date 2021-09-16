## 封装
> 隐藏内部实现，仅对外暴露简单的调用形式即可，提高代码安全性 -> 符合程序设计中的'高内聚、低耦合'
> 高内聚：内部完成数据操作，尽量少的外部干涉
> 低耦合：仅对外暴露调用形式，尽量减少模块间的联系

> 类中封装思想的体现：主要是对属性封装
> 1. 属性私有化 private修饰
> 2. 提供public修饰的方法供外界调用 -> setter/getter方法[IDEA快捷键生成alt+insert,选择'getterandsetter']
> -> 外界可访问属性，但不能随意访问，方法中添加了限制条件
```java
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
```