## 对象流
> 背景：对象是用于组织存储数据，开发中往往需要将对象存储到硬盘上的文件、网络传输对象数据等 -> 网络传输数据的格式仅能是二进制序列，无论是字节流还是字符流最终都需转换为二进制形式，关于java对象的传输，就需要用到序列化、反序列化
> 序列化：发送方将java对象转换为字节序列，才能在网络上传送
> 反序列化：接收方将字节序列转换为对象，才能正常读取

> 对象序列化的作用：
> 持久化：对象转换为字节序列永久存储在硬盘，通常放到文件中 -> 只有转换为字节序列才可存入到文件
> 网络通信：网络上传输对象的字节序列 -> 服务器间的数据通信、对象传递

### 序列化涉及的类与接口
> 1. 只有实现了Serializable接口的类的对象才能被序列化，Serializable是空接口，仅起到标记作用
> 2. ObjectOutputStream对象输出流：对象序列化为字节序列
> 3. ObjectInputStream对象输入流：字节序列反序列化为对象并返回
> -> 这些对象流不仅可处理java对象，还可对基本数据类型进行读写操作，但数据流[DataInputStream、DataOutputStream]仅能对基本数据类型和字符串类型进行处理，不能处理java对象

```java
// 操作基本类型数据
package com.mi.demo;

import java.io.*;

public class ObjectOutputStreamBasicTypeDemo {
  public static void main(String[] args) {
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    try {
      oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\workspace\\dev\\1.技术体系\\2.后端\\javastudy\\a.txt")));
      oos.writeChar('a');
      oos.writeInt(10);
      oos.writeDouble(Math.random());
      oos.writeBoolean(true);
      oos.writeUTF("你好");
      oos.flush();

      ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("C:\\workspace\\dev\\1.技术体系\\2.后端\\javastudy\\a.txt")));
      // 读取顺序要保持一致
      System.out.println("char: " + ois.readChar());
      System.out.println("int: " + ois.readInt());
      System.out.println("double: " + ois.readDouble());
      System.out.println("boolean: " + ois.readBoolean());
      System.out.println("String: " + ois.readUTF());
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(oos != null) {
          oos.close();
        }
        if(ois != null) {
          ois.close();
        }
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }
}
```


```java
// 操作对象
package com.mi.demo;

import java.io.*;

public class ObjectOutputStreamObjectTypeDemo {
  public static void main(String[] args) {
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    try {
      oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\workspace\\dev\\1.技术体系\\2.后端\\javastudy\\e.txt")));
      Users users = new Users("curry",18);
      oos.writeObject(users);
      oos.flush();

      ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("C:\\workspace\\dev\\1.技术体系\\2.后端\\javastudy\\e.txt")));
      Users user = (Users)ois.readObject();
      System.out.println(user.getUsername() + "：" + user.getAge());
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(oos != null) {
          oos.close();
        }
        if(ois != null) {
          ois.close();
        }
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }
}
```