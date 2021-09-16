package com.mi.set;

import java.util.Set;
import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // 新增
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("a");

        // 获取元素 -> Set容器没有索引，没有get()方法
        for(String str: set) {
            System.out.println(str);
        }

        // 删除
        boolean flag = set.remove("a");
        System.out.println(flag);

        // 长度
        int size = set.size();
        System.out.println(size);
    }
}