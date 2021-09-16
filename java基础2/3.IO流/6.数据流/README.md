## 数据流
> 本质：基本数据类型与字符串类型作为数据源，程序可以直接在底层输入输出流中操作基本数据类型与字符串类型 -> DataInputStream、DataOutputStream

```java
package com.mi.demo;

import java.io.*;

public class DataStreamDemo {
  public static void main(String[] args) {
    DataInputStream dis = null;
    DataOutputStream dos = null;
    try {
      // 写入
      dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\workspace\\dev\\javastudy\\data.txt")));
      dos.writeChar('a');
      dos.writeInt(10);
      dos.writeDouble(Math.random());
      dos.writeBoolean(true);
      dos.writeUTF("你好");
      dos.flush();

      dis = new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\workspace\\dev\\javastudy\\data.txt")));
      // 读取顺序要保持一致
      System.out.println("char: " + dis.readChar());
      System.out.println("int: " + dis.readInt());
      System.out.println("double: " + dis.readDouble());
      System.out.println("boolean: " + dis.readBoolean());
      System.out.println("String: " + dis.readUTF());
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(dos != null) {
            dos.close();
        }
        if(dis != null) {
            dis.close();
        }
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }
}
```