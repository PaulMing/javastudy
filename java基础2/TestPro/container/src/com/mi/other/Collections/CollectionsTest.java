package com.mi.other.Collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("b");
        list.add("e");
        list.add("d");

        // void sort(List);// 对元素进行排序 -> 升序
        Collections.sort(list);
        for(String str: list) {
            System.out.println(str);
        }

        // void shuffle(List);// 对元素进行随机排列
        Collections.shuffle(list);
        for(String str: list) {
            System.out.println(str);
        }

        // void fill(List,Object);// 用特定的对象重写整个List容器
        Collections.fill(list,"newStr");
        for(String str: list) {
            System.out.println(str);
        }
    }
}