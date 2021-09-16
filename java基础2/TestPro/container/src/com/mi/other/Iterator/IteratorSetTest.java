package com.mi.other.Iterator;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorSetTest {
    public static void main(String[] args) {
         Set<String> set= new HashSet<>();
         // 新增
         set.add("a");
         set.add("b");
         set.add("c");

         // 迭代器对象
         Iterator<String> iterator = set.iterator();
         // 迭代方式1
         while(iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
         }
         // 迭代方式2
         for(Iterator<String> it = set.iterator(); it.hasNext();) {
            String value = it.next();
            System.out.println(value);
         }
    }
}