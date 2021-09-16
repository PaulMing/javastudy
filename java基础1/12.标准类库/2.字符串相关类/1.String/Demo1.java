/**
 * 方法：Sting类是不可变字符序列，因此对字符串的操作，若返回字符串必然返回新字符串对象
 */
public class Demo1 {
  public static void main(String[] args) {
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
  }
}