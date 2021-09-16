package com.mi.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class FileReaderDemo {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader("C:\\workspace\\dev\\javastudy\\a.txt");
            fw = new FileWriter("C:\\workspace\\dev\\javastudy\\c.txt");
            // 缓冲流[处理流]：FileReader/FileWrite仅能按字符一个个读取，效率较低，缓冲流提供了'按行读取'方法，效率更高
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            String temp = "";
            while((temp = br.readLine()) != null) {
                bw.write(temp);
                bw.newLine();//换行
                System.out.println(temp);
            }
            // 刷新 -> 将数据从内存写入到硬盘
            bw.flush();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
                if(fr != null) {
                    fr.close();
                }
                if(bw != null) {
                    bw.close();
                }
                if(fw != null) {
                    fw.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}