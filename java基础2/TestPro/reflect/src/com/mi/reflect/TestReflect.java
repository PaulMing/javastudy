/*
   反射；获取类对象
*/
package com.mi.reflect;

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException {








        Class c1 = Class.forName("com.mi.reflect.User");
        Class c2 = Class.forName("com.mi.reflect.User");
        Class c3 = Class.forName("com.mi.reflect.User");
        Class c4 = Class.forName("com.mi.reflect.User");


        System.out.println(c1);
        // 一个类在内存中仅有一个class对象
        // 一个类被加载后，类的整个结构都会被封装在class对象中
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());

        System.out.println(c1.getName());



    }
}

// 实体类：只有属性  pojo entity
class User {
    private String name;
    private int id;
    private int age;

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

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