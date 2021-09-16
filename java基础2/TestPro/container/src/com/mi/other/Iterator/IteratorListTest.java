package com.mi.other.Iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class IteratorListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 新增
        list.add("a");
        list.add("b");
        list.add("c");

        // 迭代器对象
        Iterator<String> iterator = list.iterator();
        // 迭代方式1
        while(iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
        }
        // 迭代方式2
        for(Iterator<String> it = list.iterator(); it.hasNext();) {
            String value = it.next();
            System.out.println(value);
        }

        // 删除
        while(iterator.hasNext()) {
            String value = iterator.next();
            if("b".equals(value)) {
                iterator.remove();
                System.out.println(value);
            }
        }
    }
}