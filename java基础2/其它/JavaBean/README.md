## JavaBean -> 咖啡豆[java:咖啡 bean:豆子]
> java提供的可重用组件，实际就是代码的标准格式 -> 类必须是公共的、属性必须使用封装[private修饰属性，暴露getter/setter方法]、具有无参构造器，建议也写上全参构造器

> 优点：
> 1. 数据库映射ORM：类 -> 表、属性 -> 表字段、对象 -> 表的行记录 -> javabean是标准代码格式，约束数据很nice[严谨]
> 2. 提高代码复用性，其它Java类可通过反射机制发现和操作这些JavaBean的属性

```java
package com.mi.javabean;

public class TestJavaBean {
  private int id;
  private String name;

  public TestJavaBean() {}

  public TestJavaBean(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
```