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