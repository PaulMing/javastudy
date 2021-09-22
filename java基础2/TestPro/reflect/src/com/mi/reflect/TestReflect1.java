package com.mi.reflect;

public class TestReflect1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        Class c2 = Class.forName("com.mi.reflect.Student");
        System.out.println(c2.hashCode());

        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        // 基本内置类型的包装类都有一个type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4.hashCode());

        // 获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {

    }

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
