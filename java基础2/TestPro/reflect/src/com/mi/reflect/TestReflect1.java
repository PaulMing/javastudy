/*
   反射；获取类对象
*/
package com.mi.reflect;

public class TestReflect1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取类对象的三种方式
        // 方式1：obj.getClass()
        Person person = new Student();
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        // 方式2：Class.forName(类名)
        Class c2 = Class.forName("com.mi.reflect.Student");
        System.out.println(c2.hashCode());

        // 方式3：类名.class
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        // 基本内置类型的包装类都有一个type属性,属性值为类对象 -> 仅限包装类
        Class c7 = Integer.TYPE;
        System.out.println(c7.hashCode());

        // 获得父类类型
        Class c8 = c1.getSuperclass();
        System.out.println(c8);
    }
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {}

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    public Student() {
        this.name = "stu";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "";
    }
}