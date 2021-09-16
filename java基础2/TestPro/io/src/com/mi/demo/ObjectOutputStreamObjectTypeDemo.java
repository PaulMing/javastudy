/*
    对象流：
      背景：对象是用于组织存储数据，开发中往往需要将对象存储到硬盘上的文件、网络传输对象数据等 -> 网络传输数据的格式仅能是二进制序列，无论是字节流还是字符流最终都需转换为二进制形式，关于java对象的传输，就需要用到序列化、反序列化
      序列化：发送方将java对象转换为字节序列，才能在网络上传送
      反序列化：接收方将字节序列转换为对象，才能正常读取

      -> 这些对象流不仅可处理java对象，还可对基本数据类型进行读写操作，但数据流[DataInputStream、DataOutputStream]仅能对基本数据类型和字符串类型进行处理，不能处理java对象
*/
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