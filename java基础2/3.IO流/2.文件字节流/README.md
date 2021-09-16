## 文件字节流
> InputStream/OutputStream抽象类的两个具体实现类：FileInputStream/FileOutputStream -> 适合所有类型文件，图像、视频、文本文件等，但文本文件建议使用字符流处理，例如FileReader

```java
package com.mi.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

public class FileStreamBuffedDemo {
  public static void main(String[] args) {
    FileInputStream fis = null;
    FileOutputStream fos = null;
    // 缓存流 -> 处理流
    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;
    try{
      fis = new FileInputStream("C:\\workspace\\dev\\1.技术体系\\2.后端\\javastudy\\a.jpg");
      bis = new BufferedInputStream(fis);

      fos = new FileOutputStream("C:\\workspace\\dev\\1.技术体系\\2.后端\\javastudy\\a1.jpg");
      bos = new BufferedOutputStream(fos);

      int temp = 0;
      while(temp != -1) {
          temp = fis.read();
          bos.write(temp);
      }
      // 刷新：将数据从内存写入磁盘中
      bos.flush();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        // 关闭流顺序：【成对】后开先关闭
        if(bis != null){
          bis.close();
        }
        if(fis != null) {
          fis.close();
        }
        if(bos != null) {
          bos.close();
        }
        if(fos != null) {
          fos.close();
        }
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }
}
```