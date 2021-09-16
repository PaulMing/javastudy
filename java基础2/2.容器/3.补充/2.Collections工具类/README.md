## Collections工具类
> 其是辅助工具类，提供的都为静态方法 -> 主要用于对Set、List、Map等容器进行排序、查找等处理

> 常用方法：
> void sort(List);// 对元素进行排序 -> 升序
> void shuffle(List);// 对元素进行随机排列
> void reverse(List);// 对元素进行逆序排列
> void fill(List,Object);// 用特定的对象重写整个List容器
> int binarySearch(List,Object);// 对于顺序容器，采用折半查找的方法查找特定对象

```java
package com.mi.other;

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
```