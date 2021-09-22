## 注解Annotation
> JDK1.5引入的新技术，对程序解释 + 辅助编程能力 -> 其大多数时候可做到'编译期间提出警告'，符合JAVA强类型的语言标准[强约束]

### 注解的使用
> 格式：@注释名，还可添加些参数值，@suppressWarnings(value="unchecked")
> 场景：附加在package、class、method、field等上面，可通过反射机制实现对这些'元数据'访问
> 分类：内置注解、元注解、自定义注解

> 内置注解 -> JDK提供的注解[3种]
```java
/*
  内置注解：
    @Override: 仅用于修饰方法，某方法声明需重写超类中的方法声明 -> java.lang.Override包

    @Deprecated: 用于修饰属性、方法、类，表示不建议使用，因为其很危险[可能废弃]或者有更好的替代选择，实际也是因为JDK的发展导致某些库未来不被使用，但目前依旧被使用 -> java.lang.Deprecated

    @SuppressWarnings: 用于修饰属性、方法、类，抑制编译时的警告信息，需要添加参数才可使用[预定义参数] -> java.lang.SuppressWarnings
      @SuppressWarnings("all")
      @SuppressWarnings("unchecked")
      @SuppressWarnings(value={"unchecked","deprecation"})
*/
package com.mi.annotation;

import java.util.ArrayList;
import java.util.List;

public class TestInside extends Object {
  @Override
  public String toString() {
    System.out.println("");
    return "";
  };

  @Deprecated
  public static void test() {
    System.out.println("不建议使用");
  }

  @SuppressWarnings("all")
  public void demo() {
    List<String> list = new ArrayList<String>();// 定义list却不使用，其会报警告，使用@SuppressWarnings()注解，其会抑制警告
  }

  public static void main(String[] args) {
    test();
  }
}
```

> 元注解 -> 注解其它注解[4种]
```java
/*
  元注解：
    负责注解其它注解，java定义了4个标准meta-annotation类型 -> java.lang.annotation包
    -> 常用于自定义注解使用，可参考'内置注解'源码
    @Target: 描述注解的使用范围
    @Retention: 描述注解的生命周期[需要在什么级别保存该注释信息]，SOURCE[源码] < CLASS[编译] < RUNTIME[运行]，默认值RUNTIME
    @Documented: 注解将被包含在javadoc
    @Inherited: 子类可继承父类中的该注解
*/
package com.mi.annotation;

import java.lang.annotation.*;

public class TestMeta {
  @MyAnnotation
  public void test() {

  }
}

// 自定义注解
@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(value = RetentionPolicy.CLASS)
@Documented
@Inherited
@interface MyAnnotation { }
```

> 自定义注解
```java
/*
  自定义注解：
    public @interface 注解名 {定义内容}
*/
package com.mi.annotation;

import java.lang.annotation.*;

public class custom {
  @customAn(name = "new")
  public void test() {

  };
};

// 自定义注解
@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@Documented
@Inherited
@interface customAn {
  /*
    参数格式：
      参数类型 参数名() 默认值[可选] -> 其并不是方法
      -> 使用时需要填写参数 @customAn(name="") 参数=参数类型
      -> 当仅有一个参数时，参数名必须为value,使用时value可省略 @customAn(value="") 等价于 @customAn("")
  */
  String name() default "";
  int age() default 0;
  int id() default -1;// 若默认值为-1，表示不存在
  String[] schools() default {"a","b"};
}
```

### 注解 vs 注释
> 它们都不是程序本身，就是对程序作出解释
> 注解：可被其它程序读取[例如：编译器] -> 解释 + 辅助编程
> 注释：仅被开发者读取，仅对代码做出解释即可