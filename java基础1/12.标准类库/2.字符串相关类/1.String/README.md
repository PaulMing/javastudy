## String类
> 背景：java并没有内置字符串数据类型，而是提供了预定义类String，每个双引号括起来的字符串都是String类的实例

> ## 特性
> 1. java字符串是不可变字符序列：其就是Unicode字符序列，例如java就是由4个Unicode字符'j'、'a'、'v'、'a'组成 -> 底层就是字符数组，数组长度便不可修改
```java
// 源码
private final char value[];//使用了final修饰 -> 不可变对象
```
> 2. 其位于java.lang包，无需导入便可使用

### 基本使用
```java
/*
  字符串定义：
    1.字面量：
      String s = "Hello";//底层调用new String("Hello");
    2.对象创建：
      String s = new String("Hello")
*/ 

/*
  字符串连接：
    1.使用+号运算符可将字符串按顺序拼接在一起
    2.+号运算符两侧的操作数只要有一个是字符串类型，系统会自动将另一个操作数隐式转换为字符串然后进行拼接
*/
String s1 = "Hello";
String s2 = "World";
String s3 = s1 +s2;//"HelloWorld"

int count = 520;
String s4 = "count值是：" + count;//"count值是520"

/*
  字符串相等判断：
    equals();//String类进行了重写，其比较堆区中的值是否相等 -> Object类中的equals方法依旧判断栈区的地址/引用是否相等
*/
String s1 = "hi";
String s2 = "hi";
System.out.println(s1 == s2);//true -> 它们指向同一地址
System.out.println(s1.equals(s2));//true
String s3 = new String("hi");
System.out.println(s1 == s3);//false
System.out.println(s1.equals(s3));//true
```

### 方法
```java
String str = "HelloWorld";

// int length() 返回字符串长度
int len = str.length();
System.out.println(len);

// char charAt(int index) 返回字符串中第index个字符 -> 越界会报异常java.lang.StringIndexOutOfBoundsException
char str1 = str.charAt(10);
System.out.println(str1);

// int indexOf(String str) 返回从头开始查找str在字符串中的索引位置，若未找到则返回-1
int seatStart = str.indexOf("World");

// int lastIndexOf(String str) 返回从尾开始查找str在字符串中的索引位置，若未找到则返回-1
int seatEnd = str.lastIndexOf("ld");

// String substring(int beginIndex,[int endIndex]) 截取从beginIndex到endIndex-1的字符串[包头不包尾]，若endIndex不写，则截取从beginIndex到末尾的字符串，若endIndex超出了字符串length,默认截取到末尾
String str2 = str.substring(2,6);
String str3 = str.substring(2)


// boolean startsWith(String str) 判断字符串是否以str开头，返回布尔值
System.out.println(str.startsWith("Hel"))

// boolean endsWith(String str) 判断字符串是否以str结尾，返回布尔值
System.out.println(str.endsWith("ld"))

// boolean equalsIgnoreCase(String str) 判断字符串是否与str相等，判断时忽略大小写
String str4 = "HelloWORLD";
System.out.println(str4.equalsIgnoreCase(str));//true


// String toLowerCase() 将字符串中所有大写字母改成小写字母
String str5 = str.toLowerCase();

// String toUpperCase() 将字符串中所有小写字母改成大写字母
String str6 = str.toUpperCase();

// String replace(char oldChar, char newChar) 替换单个字符
// String replace(String oldStr, String newStr) 替换字符串
String str7 = str.replace('W','w');
String str8 = str.replace('World','Java');

// String trim() 去掉字符串中首尾空格 -> 其并不会去掉字符串中间的空格，可使用replace方法进行空串替换
String str9 = " HelloWorld ";
str.trim();
String str10 = " Hell o World ";
str.trim().replace(" ","");
```