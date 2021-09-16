## TreeMap类 -> Map接口的实现类
> 基于哈希表实现[实际就是数组+链表]，但可对容器内元素排序 -> 基于排序规则进行排序

```java
package com.mi.map;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import com.mi.set.treeset.Student;
import com.mi.set.treeset.StudentComparator;
import com.mi.set.treeset.Users;

public class TreeMapTest {
  public static void main(String[] args) {
    // 其它方法同HashMap使用方法类似

    /*
      排序规则：
        1.通过元素自身实现：元素需实现Comparable接口的compareTo方法[字符串or数字类中都已实现该抽象方法,自定义类中没有该方法则需要实现] -> 方法聚焦返回值：正数，位置不变; 负数，位置互换; 0,保持不变
        2.通过比较器指定：
            [1].单独创建比较器，比较器需实现Comparator接口中的compare方法定义比较规则
            [2].实例化TreeSet时将比较器对象传入以完成元素的排序处理
    */
    // 通过元素自身实现
    Map<Users,String> map = new TreeMap<>();
    Users u = new Users("lisa",18);
    Users u1 = new Users("curry",20);
    Users u2 = new Users("acy",20);
    map.put(u,"lisa");
    map.put(u1,"curry");
    map.put(u2,"acy");
    Set<Users> keys = map.keySet();
    for(Users key: keys) {
        System.out.println(key + ":" + map.get(key));
    }

    // 通过比较器指定
    Map<Student,String> map1 = new TreeMap<>(new StudentComparator());
    Student s1 = new Student("lisa",18);
    Student s2 = new Student("curry",20);
    Student s3 = new Student("acy",20);
    map1.put(s1,"lisa");
    map1.put(s2,"curry");
    map1.put(s3,"acy");
    Set<Student> keys1 = map1.keySet();
    System.out.println(keys1);
    for(Student key: keys1) {
        System.out.println(key + ":" + map1.get(key));
    }
  }
}

// Users类
public class Users implements Comparable<Users>{
  // alt+insert -> 自动生成getter/setter
  private String username;
  private int age;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Users(String username, int age) {
    this.username = username;
    this.age = age;
  }

  // toString()
  @Override
  public String toString() {
    return "Users{" +
            "username='" + username + '\'' +
            ", age=" + age +
            '}';
  }

  // 通过元素自身实现：元素需实现Comparable接口的compareTo方法 -> 聚焦返回值：正数，位置不变； 负数，移动前面; 0: 位置不变
  @Override
  public int compareTo(Users o) {
    if(this.age > o.getAge()) {
      return 1;
    }
    if(this.age == o.getAge()) {
      return this.username.compareTo(o.getUsername());
    }
    return -1;
  }
}


// StudentComparator类
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
```