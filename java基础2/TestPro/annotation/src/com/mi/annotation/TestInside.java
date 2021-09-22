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