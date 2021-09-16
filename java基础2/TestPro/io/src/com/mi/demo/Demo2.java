package com.mi.demo;

import java.io.FileInputStream;

public class Demo2 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis =  new FileInputStream("C:\\workspace\\dev\\1.技术体系\\2.后端\\javastudy\\a.txt");
            StringBuilder strBu = new StringBuilder();
            int temp = 0;
            while(temp != -1) {
                temp = fis.read();
                System.out.println(temp);
                strBu.append((char)temp);
            }
            System.out.println(strBu);
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