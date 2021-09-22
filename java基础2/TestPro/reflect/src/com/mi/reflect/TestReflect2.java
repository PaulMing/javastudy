package com.mi.reflect;

import java.lang.annotation.ElementType;

public class TestReflect2 {
    public static void main(String[] args) {
        Class c1 = Object.class;// 类
        Class c2 = Comparable.class;// 接口
        Class c3 = String[].class;;// 数组
        Class c4 = int[][].class;// 二维数组
        Class c5 = Override.class; //注解
        Class c6 = ElementType.class;//枚举
        Class c7 = Integer.class;// 包装类
        Class c8 = void.class;// void -> 空类型
        Class c9 = Class.class;// Class类


        // 只要元素类型与维度一致，就是同一个class，实际就是数组类
        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());



    }
}
