package com.mi.apacheio;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;

public class IOUtilsDemo {
    public static void main(String[] args) throws IOException {
        String content = IOUtils.toString(new FileInputStream("C:\\workspace\\dev\\1.技术体系\\2.后端\\javastudy\\a.txt"),"utf-8");
        System.out.println(content);
    }
}