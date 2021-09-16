## ArrayList类 -> List接口的实现类
> 底层基于数组实现：查询效率高、增删效率低，线程不安全

```java
package com.mi.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();

    // 添加
    boolean flag1 = list.add("hello");
    boolean flag2 = list.add("world");
    System.out.println(flag1);
    // 插入
    list.add(1,"insertElement");

    // 获取元素
    for(int i=0; i< list.size(); i++) {
      System.out.println(list.get(i));
    }

    // 删除元素
    String ele = list.remove(1);
    System.out.println(ele);
    boolean res = list.remove("world");
    System.out.println(res);

    // 替换元素
    String val = list.set(0,"newHello");
    System.out.println(val);// 替换掉的元素

    // 清空容器
    list.clear();

    // 判定容器是否为空
    boolean isEmpty = list.isEmpty();
    System.out.println(isEmpty);

    // 是否包含某元素
    list.add("Hello");
    list.add("Hello1");
    boolean isExist = list.contains("world");
    System.out.println(isExist);

    // 查找元素位置
    int index = list.indexOf("Hello");
    System.out.println(index);
    int lastIndex = list.lastIndexOf("Hello");
    System.out.println(lastIndex);

    // 单例集合转换为数组
    Object[] arr = list.toArray();
    for(int i=0; i<arr.length; i++) {
      String str = (String)arr[i];
      System.out.println(str);
    }
    String[] arr2 = list.toArray(new String[list.size()]);
    for(int i=0; i<arr2.length; i++) {
      System.out.println(arr2[i]);
    }

    // 多集合操作
    List<String> a = new ArrayList<>();
    a.add("a");
    a.add("b");
    a.add("c");
    List<String> b = new ArrayList<>();
    b.add("d");
    b.add("e");
    b.add("f");
    b.add("c");
    // 并集
    boolean newFlag = a.addAll(b);//若b为空集，返回false -> 实际也没必要对空集求并集
    System.out.println(newFlag);
    for(String str: a) {
        System.out.println(str);
    }

    // 交集
    boolean newFlag1 = a.retainAll(b);
    for(String str: a) {
        System.out.println(str);
    }

    // 差集
    boolean newFlag2 = a.removeAll(b);
    for(String str: a) {
        System.out.println(str);
    }
  }
}
```