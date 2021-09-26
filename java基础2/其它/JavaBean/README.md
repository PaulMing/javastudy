## JavaBean
> JAVA语言写成的可重用组件，实际就是代码的标准格式 -> 类必须是公共的、属性必须使用封装[private修饰属性，暴露getter/setter方法]、具有无参构造器，建议也写上全参构造器
> 优势：
> 1. 提高代码复用性，事务处理逻辑、数据库操作等都可封装在JavaBean
> 2. 其它Java类可通过反射机制发现和操作这些JavaBean的属性

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