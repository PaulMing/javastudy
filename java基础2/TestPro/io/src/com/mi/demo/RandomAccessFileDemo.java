/*
    随机访问流：
      1.实现对文件的读写操作
      2.可操作文件的任意位置，其它流处理仅能按先后顺序操作 -> 开发某些客户端系统时，经常会用到这个'可任意操作文件内容'的类，java目前很少用于开发客户端软件，所以使用场景较少

      常用方法：
        RandomAccessFile(String name, String mode);//name：文件名; mode: r(读)/rw(读写),文件访问权限
        seek(long a);//定位流对象读写文件的位置，a表示读写位置距离文件开头的字节个数
        getFilePointer();//获得流的当前读写位置
*/
package com.mi.demo;

import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) {
        RandomAccessFile raf = null;
        try {
            int[] arr = new int[]{10,20,30,40,50,60,70,80,90,100};
            for(int i=0; i<arr.length; i++){
                raf.writeInt(arr[i]);
            }
            raf.seek(4);//操作int类型数据，int占4个字节，也就是此时其在20所在字节的位置
            System.out.println(raf.readInt());

            // 隔一个读取一个数据
            for(int i=0; i<10; i+=2) {
                raf.seek(i*4);
                System.out.print(raf.readInt() + "\t");
            }
            System.out.println();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(raf != null) {
                    raf.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}