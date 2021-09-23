/*
   获取注解信息/反射操作注解：
*/
package com.mi.reflect;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class TestReflect6 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.mi.reflect.Animal");
        // 获取所有注解 -> 默认是类注解
        Annotation[] annotations = c1.getAnnotations();
        for(Annotation annotation: annotations) {
            System.out.println(annotation);
        }
        // 获取类注解的值 -> 通过此方式就可获取到元数据
        TableDeal tableDeal = (TableDeal)c1.getAnnotation(TableDeal.class);
        String value = tableDeal.value();
        System.out.println(value);

        // 获得类指定的注解
        Field f1 = c1.getDeclaredField("name");
        FieldDeal annotation = f1.getAnnotation(FieldDeal.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@TableDeal("db_student")
class Animal {
    @FieldDeal(columnName = "db_id", type="int", length = 10)
    private int id;
    @FieldDeal(columnName = "db_age", type="int", length = 10)
    private int age;
    @FieldDeal(columnName = "db_name", type="varchar", length = 10)
    private String name;

    public Animal(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Animal() { }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 类注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableDeal {
    String value();
}

// 属性注解
@interface FieldDeal {
    String columnName();
    String type();
    int length();
}