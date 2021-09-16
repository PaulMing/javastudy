package com.mi.set.treeset;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    // 定义比较规则
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAge() > o2.getAge()) {
            return 1;
        }
        if(o1.getAge() == o2.getAge()) {
            return o1.getName().compareTo(o2.getName());
        }
        return -1;
    }
}