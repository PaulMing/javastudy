## HashSet类 -> Set接口的实现类
> 基于哈希表实现[实际就是数组+链表，采用哈希算法/散列算法，底层就是基于HashMap实现]，查询增删效率都较高，而且允许有null元素，线程不安全，无排序能力 => 存储过程：首先调用元素的hashCode()方法获取hashCode值，拿到该值后根据某些规则确定位置，若多个元素得到的hash值是相同的，那么就在同位置下使用链表连接，这就是哈希算法，查找过程也是通过哈希算法进行查找[比遍历查找效率高]

```java
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
```