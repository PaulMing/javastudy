## 包
> 背景：模块化代码，解决重名、访问权限的问题 -> 命名空间

### 包创建/包命名
> 1. 全部小写，中间用.分隔
> 2. 不能使用系统中的关键字：nul、con等 
> -> 大多都是公司域名倒着写，然后加上模块名字：com.jd.login、com.jd.register

### 包声明
> 直接写在非注释性代码的第一行
```java
// 声明包
package com.jd.login
```

### 导入包
```java
/*
  1.同包下的类使用无需导包，直接使用即可
  2.使用不同包下的类均需要导包：
    -> 导入自定义包下的类：直接导入，无法省略
    -> 导入标准库的包：某些情况可省略
       [1].java.lang包下的类无需导入直接使用即可[编译时默认导入java.lang包下的所有类]
       [2].使用*表示导入所有类：import java.util.* -> import java.util.ArrayList、import java.util.Date
       [3].java中的导包没有'包含/被包含'的关系
           import com.jd.*;
           import com.jd.login.A;//即使导入import com.jd.* 但login包下的类也没有被导入 -> 它们没有包含关系
       [4].静态导入 -> 使用static关键字
           import static java.lang.Math.*;//导入Math类中的所有静态内容，代码书写时可以简写Math
           public class Demo {
              public static void main(String[] args) {
                System.out.println(random());//Math.random()
                System.out.println(PI);//Math.PI
              }
              // 静态导入后，同一个类中有相同方法时会优先'用户自定义'方法
              public static int round(double a) {
                return 1000;
              }
              System.out.println(round(6.8));//1000，而不是Math.round(6.8)
           }
*/
```