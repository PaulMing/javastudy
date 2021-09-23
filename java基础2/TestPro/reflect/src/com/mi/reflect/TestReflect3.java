/*
   获取类对象运行时的内部结构：
      -> 实际类对象本质也是对象，操作属性、方法就会很便捷
      包名、类名、属性、方法等
*/
package com.mi.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.mi.reflect.User");

        // 包名
        System.out.println(c1.getName());

        // 类名
        System.out.println(c1.getSimpleName());

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
        // 获取具体属性
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        // 获取方法
        // 类以及父类public方法
        Method[] methods = c1.getMethods();
        for(Method method: methods) {
            System.out.println(method);
        }
        // 类方法
        Method[] methods1 = c1.getDeclaredMethods();
        for(Method method: methods1) {
            System.out.println(method);
        }
        // 获取具体方法
        Method name1 = c1.getMethod("getName",null);
        System.out.println(name1);
        Method name2 = c1.getMethod("setName",String.class);
        System.out.println(name2);

        // 获取构造器
        // 获取public构造器
        Constructor[] constructors = c1.getConstructors();
        for(Constructor constructor: constructors) {
            System.out.println(constructor);
        }
        // 获取所有构造器方法
        Constructor[] constructors1 = c1.getDeclaredConstructors();
        for(Constructor constructor: constructors1) {
            System.out.println(constructor);
        }
        // 获取具体构造器
        Constructor construct = c1.getDeclaredConstructor(String.class,int.class,int.class);
        System.out.println(construct);
    }
}

// 实体类 pojo entity
class User {
    private String name;
    private int id;
    private int age;

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}