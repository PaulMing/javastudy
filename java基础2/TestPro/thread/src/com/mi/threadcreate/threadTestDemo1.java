/*
    多线程并发下载图片
*/
package com.mi.threadcreate;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class threadTestDemo1 extends Thread{
    public String url;
    public String name;

    public threadTestDemo1(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url,name);
        System.out.println("download:" + name);
    }

    // main线程
    public static void main(String[] args) {
        threadTestDemo1 t1 = new threadTestDemo1("http://mat1.gtimg.com/sports/kbsweb4/assets/176e7c5f3d7dffbd0d7d.png", "1.jpg");
        threadTestDemo1 t2 = new threadTestDemo1("http://mat1.gtimg.com/sports/kbsweb4/assets/176e7c5f3d7dffbd0d7d.png", "2.jpg");
        threadTestDemo1 t3 = new threadTestDemo1("http://mat1.gtimg.com/sports/kbsweb4/assets/176e7c5f3d7dffbd0d7d.png", "3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

// 下载器
class WebDownLoader {
    public void downloader(String url,String name) {
        try {
            // 将网图下载到本地
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}