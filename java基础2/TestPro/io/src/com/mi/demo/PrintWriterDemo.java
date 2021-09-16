/*
    PrintWriter类：字符输出流
        1.自动刷新缓冲字符输出流
        2.可直接按行输出字符串
        3.可通过println()方法实现自动换行
 */
package com.mi.demo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrintWriterDemo {
    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter pw = null;

        try{
            br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\workspace\\dev\\javastudy\\a.txt")));
            pw = new PrintWriter("C:\\workspace\\dev\\javastudy\\c.txt");

            String temp = "";
            int i = 1;
            while((temp = br.readLine()) != null) {
                pw.println(i+","+temp);
                i++;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(br != null) {
                    br.close();
                }
                if(pw != null) {
                    pw.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}