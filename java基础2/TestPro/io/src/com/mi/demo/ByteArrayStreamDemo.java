/*
    字节数组输入流/输出流：
       本质：字节数组对象作为数据源
       ByteArrayInputStream、ByteArrayOutputStream
*/
package com.mi.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream bos = null;
        ByteArrayInputStream bis = null;
        try {
            bos = new ByteArrayOutputStream();
            bos.write('a');
            bos.write('b');
            bos.write('c');
            byte[] arr = bos.toByteArray();
            System.out.println(arr);


            bis = new ByteArrayInputStream(arr);
            StringBuilder sb = new StringBuilder();
            int temp = 0;
            while((temp = bis.read()) != -1) {
                sb.append((char)temp);
            }
            System.out.println(sb);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(bis != null) {
                    bis.close();
                }
                if(bos != null) {
                    bos.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}