package com.mi.demo;

import java.io.FileInputStream;

public class Demo1 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis =  new FileInputStream("C:\\workspace\\dev\\1.技术体系\\2.后端\\javastudy\\a.jpg");
            int s1 = fis.read();//每次读取一个字节的数据，返回int类型值 -> 仅能一个个读取
            int s2 = fis.read();
            System.out.println(s1);
            System.out.println(s2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}