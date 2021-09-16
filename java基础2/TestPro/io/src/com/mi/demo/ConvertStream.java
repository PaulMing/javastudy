/*
    字节字符转换流：
        背景：开发中会遇到字节字符流转换情况，例如System.in/System.out就是字节流对象，每次仅能获取一个字节，但我们需要以行为单位操作数据，就会用到缓冲字符流提供的readLine()/writeLine()，但这两个方法仅能处理字符流，因此需要进行转换 -> JAVA提供了两个类InputStreamReader/OutputStreamWriter
*/
package com.mi.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ConvertStream {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));

            while(true) {
                bw.write("请输入：");
                bw.flush();
                String input = br.readLine();
                bw.write("输入的是：" + input);
                bw.newLine();
                bw.flush();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(bw != null) {
                    bw.close();
                }
                if(br != null) {
                    br.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}