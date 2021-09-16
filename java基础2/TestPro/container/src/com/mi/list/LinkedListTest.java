package com.mi.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        // 新增
        list.add("a");
        list.add("b");
        list.add("c");

        // 获取
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }

        LinkedList<String> linkedList = new LinkedList<>();
        // 新增
        linkedList.addFirst("a");
        linkedList.addFirst("b");
        linkedList.addLast("c");
        linkedList.addLast("c");
        for(String str:linkedList) {
            System.out.println(str);
        }

        // 删除
        linkedList.removeFirst();
        linkedList.removeLast();
        for(String str:linkedList) {
            System.out.println(str);
        }

        // 判空
        boolean flag = linkedList.isEmpty();
        System.out.println(flag);
    }
}
