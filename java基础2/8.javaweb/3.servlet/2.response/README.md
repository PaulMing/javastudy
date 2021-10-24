## response
> 其表示服务端的响应，响应信息相关接口都被封装到HttpServletResponse

### 常见应用：
> 1. 向客户端发送信息
> 2. 下载文件
> 3. 重定向

```java
package com.tt.servlet;

public class FileServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 文件下载：

    // 1.获取下载文件的路径 -> classpath or 资源的绝对路径
    String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/mvn.png");
    // String realPath = "C:\\workspace\\testPro\\javaweb-03-servlet\\response\\src\\main\\resources\\mvn.png";
    System.out.println(realPath);

    // 2.下载的文件名
    String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
    System.out.println(fileName);

    // 3.设置：浏览器可支持下载
    resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));//URLEncoder.encode(fileName,"utf-8") 文件名转码，设置utf-8来支持中文

    // 4.获取下载文件的输入流
    FileInputStream in = new FileInputStream(realPath);

    // 5.创建缓冲区
    int len = 0;
    byte[] buffer = new byte[1024];

    // 6.获取输出流对象，并输出数据到客户端
    ServletOutputStream out = resp.getOutputStream();
    while((len=in.read(buffer)) > 0) {
        out.write(buffer,0,len);
    }

    // 7.关闭数据流 -> 后开先关
    in.close();
    out.close();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
```