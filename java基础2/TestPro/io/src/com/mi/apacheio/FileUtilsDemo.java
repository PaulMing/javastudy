package com.mi.apacheio;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class FileUtilsDemo {
    public static void main(String[] args) throws IOException {
        System.out.println(new File("C:\\workspace\\dev\\1.技术体系\\2.后端\\javastudy\\a.txt"));
        String content = FileUtils.readFileToString(new File("C:\\workspace\\dev\\1.技术体系\\2.后端\\javastudy\\a.txt"),"utf-8");
        System.out.println(content);

        // 拷贝文件
        FileUtils.copyDirectory(new File("d/a"), new File("d/b"), new FileFilter() {
            // 文件拷贝时的过滤条件 -> 接口内部类
            @Override
            public boolean accept(File pathname) {
                if(pathname.isDirectory() || pathname.getName().endsWith("html")){
                    return true;
                }
                return false;
            }
        });
    }
}