/*
   所有类型的Class类对象：
      1.类加载完成后，系统就会在堆内存中产生该类的Class类型对象，仅系统可创建 && 仅能创建一次
      2.类、接口、注解等都有Class类对象 -> 实际只要是类，类加载的时候就会自动创建类对象
*/
package com.mi.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.mi.reflect.User");

        c1.getName();
        System.out.println(c1.getName());//包名
        System.out.println(c1.getSimpleName());//类名

        // 获取属性
        // public属性
        Field[] fields = c1.getFields();
        for(Field field: fields) {
            System.out.println(field);
        }

        // 全部属性
        Field[] declaredFields = c1.getDeclaredFields();
        for(Field field: declaredFields) {
            System.out.println(field);
        }

        Field name = c1.getDeclaredField("name");
        System.out.println(name);


        // 获取方法
        Method[] methods = c1.getMethods();//类以及父类public方法
        for(Method method: methods) {
            System.out.println(field);
        }

        methods = c1.getDeclaredMethods();//类的方法
        for(Method method: methods) {
            System.out.println(field);
        }

        Method name1 = c1.getMethod("getName",null);
        System.out.println(name1);
        Method name2 = c1.getMethod("setName",String.class);
        System.out.println(name2);

        // 获得构造器
        Constructor[] constructors = c1.getConstructors();// public方法
        for(Constructor constructor: constructors) {
            System.out.println(constructor);
        }

        Constructor[] constructors1 = c1.getDeclaredConstructors();// 所有方法
        for(Constructor constructor: constructors1) {
            System.out.println(constructor);
        }

        Constructor construct = c1.getDeclaredConstructor(String.class,int.class,int.class);
        System.out.println(construct);
    }
}
