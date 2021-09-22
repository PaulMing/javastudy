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
