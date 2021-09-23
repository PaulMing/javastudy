/*
   所有类型的Class类对象：
      1.类加载完成后，系统就会在堆内存中产生该类的Class类型对象，仅系统可创建 && 仅能创建一次
      2.类、接口、注解等都有Class类对象 -> 实际只要是类，类加载的时候就会自动创建类对象
*/
package com.mi.reflect;

import java.lang.annotation.ElementType;

public class TestReflect2 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 类加载完成后，系统就会在堆内存中产生该类的Class类型对象，仅系统可创建 && 仅能创建一次
        Class c1 = Class.forName("com.mi.reflect.Student");
        Class c2 = Class.forName("com.mi.reflect.Student");
        Class c3 = Class.forName("com.mi.reflect.Student");
        System.out.println(c1.hashCode());//
        System.out.println(c2.hashCode());//
        System.out.println(c3.hashCode());//

        // 类、接口、注解等都有Class类对象
        Class c4 = Object.class;// 类
        Class c5 = Comparable.class;// 接口
        Class c6 = String[].class;;// 数组
        Class c7 = int[][].class;// 二维数组
        Class c8 = Override.class; //注解
        Class c9 = ElementType.class;//枚举
        Class c10 = Integer.class;// 包装类
        Class c11 = void.class;// void -> 空类型
        Class c12 = Class.class;// Class类
        // 只要元素类型与维度一致就是同一个class -> 维度不同、类型不同就不是同class类对象
        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
    }
}