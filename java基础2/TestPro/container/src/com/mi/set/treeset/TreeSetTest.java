package com.mi.set.treeset;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        // 新增
        set.add("c");
        set.add("b");
        set.add("a");
        set.add("c");

        // 获取
        for(String str: set) {
            System.out.println(str);
        }

        /*
            排序规则：
               1.通过元素自身实现：元素需实现Comparable接口的compareTo方法[字符串or数字类中都已实现该抽象方法,自定义类中没有该方法则需要实现] -> 方法聚焦返回值：正数，位置不变; 负数，位置互换; 0,保持不变
               2.通过比较器指定：
                    [1].单独创建比较器，比较器需实现Comparator接口中的compare方法定义比较规则
                    [2].实例化TreeSet时将比较器对象传入以完成元素的排序处理
        */
        // 通过元素自身实现
        Set<Users> set1 = new TreeSet<>();
        Users u = new Users("lisa",18);
        Users u1 = new Users("curry",20);
        Users u2 = new Users("aury",20);
        set1.add(u);
        set1.add(u1);
        set1.add(u2);
        for(Users user: set1) {
            System.out.println(user);
        }

        // 通过比较器指定
        Set<Student> set2 = new TreeSet<>(new StudentComparator());
        Student s1 = new Student("lisa",18);
        Student s2 = new Student("curry",20);
        Student s3 = new Student("aury",20);
        set2.add(s1);
        set2.add(s2);
        set2.add(s3);
        for(Student student: set2) {
            System.out.println(student);
        }
    }
}