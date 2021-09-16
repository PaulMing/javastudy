/*
    线程创建方式三：
      1.实现callable接口【泛型接口】,重写call方法，需要抛出异常
      2.创建执行服务对象：ExecutorService ser = Executors.newFixedThreadPool(3);
      3.提交执行：Future<Boolean> r1 = ser.submit(t1);
      4.获取结果：boolean rs1 = r1.get();
      5.关闭服务：ser.shutdownNow();
*/
package com.mi.threadcreate;

import java.util.concurrent.*;

public class threadTestDemo5 implements Callable<Boolean> {
    public String url;
    public String name;

    public threadTestDemo5(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url,name);
        System.out.println("download:" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        threadTestDemo5 t1 = new threadTestDemo5("http://mat1.gtimg.com/sports/kbsweb4/assets/176e7c5f3d7dffbd0d7d.png", "1.jpg");
        threadTestDemo5 t2 = new threadTestDemo5("http://mat1.gtimg.com/sports/kbsweb4/assets/176e7c5f3d7dffbd0d7d.png", "2.jpg");
        threadTestDemo5 t3 = new threadTestDemo5("http://mat1.gtimg.com/sports/kbsweb4/assets/176e7c5f3d7dffbd0d7d.png", "3.jpg");

        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        // 获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        // 关闭服务
        ser.shutdownNow();
    }
}
// 下载器
//class WebDownLoader {
//    public void downloader(String url,String name) {
//        try {
//            // 将网图下载到本地
//            FileUtils.copyURLToFile(new URL(url),new File(name));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}