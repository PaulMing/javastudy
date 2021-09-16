/**
 * 典型代码 - 声明异常
 * IDEA：使用ctrl+alt+t自动生成try..catch...
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Demo1 {
  public static void main(String[] args) {
    try {
      readFile("joke.txt");
    } catch (FileNotFoundException e) {
      System.out.println("所需文件不存在！");
    } catch (IOException e) {
      System.out.println("文件读写错误！");
    }
  }

  public static void readFile(String fileName) throws FileNotFoundException,IOException {
    FileReader in = new FileReader(fileName);
    int tem = 0;
    try {
      tem = in.read();
      while(tem != -1) {
        System.out.print((char)tem);
        tem = in.read();
      }
    } finally {
      if(in != null) {
        in.close();
      }
    }
  } 
}


/*
  优化版：
    try-with-resource自动关闭Closable接口的资源：
    -> JVM垃圾回收机制可对内部资源自动回收，但JVM对外部资源[调用了底层操作系统的资源]的引用却无法自动回收，例如数据库连接、网络连接、输入输出IO流等，此时需要手动关闭，否则会导致外部资源泄漏、连接池异常、文件被异常占用等
    -> JDK新增了try-with-resource，其可自动关闭实现了AutoClosable接口的类，实现类需要实现close()方法，本质就是语法糖，自动调用close()方法，编译时会转化为try-catch-fianlly语句
*/ 
import java.io.FileReader;
public class Demo2 {
  public static void main(String[] args) {
    try(FileReader reader = new FileReader("d:/a.txt")) {
      char c = (char)reader.read();
      char c2 = (char)reader.read();
      System.out.println(""+c+c2);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}