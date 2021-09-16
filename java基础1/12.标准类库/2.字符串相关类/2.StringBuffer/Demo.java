/**
 * 方法：StringBuffer类是可变字符序列，因此对字符串的操作，若返回字符串必然返回原字符串对象
 */
public class Demo {
  public static void main(String[] args) {
    StringBuffer strBuf = new StringBuffer();
    // StringBuffer strBuf = new StringBuffer("Helloworld");

    // String toString() 返回该对象的字符串形式
    System.out.println(strBuf.toString());

    // StringBuffer append(char/str) 追加单个字符、字符串
    strBuf.append('a');
    strBuf.append("HelloWorld");
    System.out.println(strBuf.toString());

    // StringBuffer insert(index,char/str) 在index的位置插入字符、字符串
    strBuf.insert(0,'I').insert(1,"想说");
    System.out.println(strBuf.toString());

    // StringBuffer delete(beginIndex,endIndex) 删除从beginIndex到endIndex-1的字符串
    strBuf.delete(0,3);
    // StringBuffer deleteCharAt(int index) 删除index位置上的字符
    strBuf.deleteCharAt(4);
    System.out.println(strBuf.toString());

    // StringBuffer reverse() 将字符序列倒序
    strBuf.reverse();
    System.out.println(strBuf.toString());


    // 其它与String类相同的方法
    // int length() 返回字符串长度
    strBuf.length();

    // char charAt(int index) 返回字符串中第index个字符 -> 越界会报异常java.lang.StringIndexOutOfBoundsException
    strBuf.charAt(3);//直接可返回字符，不用strBuf.toString().charAt(3)

    // int indexOf(String str) 返回从头开始查找str在字符串中的索引位置，若未找到则返回-1
    strBuf.indexOf("llo");

    // int lastIndexOf(String str) 返回从尾开始查找str在字符串中的索引位置，若未找到则返回-1
    strBuf.lastIndexOf("llo")

    // String substring(int beginIndex,[int endIndex]) 截取从beginIndex到endIndex-1的字符串[包头不包尾]，若endIndex不写，则截取从beginIndex到末尾的字符串，若endIndex超出了字符串length,默认截取到末尾
    strBuf.substring(2,6)
  }
}