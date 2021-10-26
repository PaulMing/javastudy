## cookie
> 背景：http是无状态协议[每次连接都是独立的，无法标识状态]，后来诞生了cookie用于标识身份信息，cookie存储在客户端，很容易被'攻击者篡改攻击服务器'，后来又出现了session，其存储在服务端 -> 现代开发中cookie、session均会用到
> cookie: 存储在客户端，服务端发送cookie到客户端，客户端请求时会携带cookie到服务端，以此来完成身份验证 -> 其是基于'客户端'的技术，会存储在客户端本地文件中[大多都在user/appdata]，并非浏览器实现的技术，浏览器仅仅是将'本地存储cookie'的文件在'控制台的Application上完成可视化呈现 && 提供一些数据操作'而已
> session: 存储在服务端

### 特性
> 一个网站[基于域名]：20个cookie、每个cookie大小限制为4kb
> 本地存储不受限制[因为就是本地存储文件，文件大小不受限制]，浏览器有限制[300个cookie上限]
> -> 每个网站都有一盒cookie饼干[上限20]

### 使用
```java
package com.tt.servlet;

public class CookieDemo1 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("测试cookie");
    // 解决中文乱码
    req.setCharacterEncoding("utf-8");
    resp.setCharacterEncoding("utf-8");


    PrintWriter out = resp.getWriter();
    out.write("hello cookie");

    Cookie[] cookies = req.getCookies();
    if(cookies != null) {
      for (int i = 0; i < cookies.length; i++) {
        if(cookies[i].getName().equals("lastLoginTime")) {
          long l = Long.parseLong(cookies[i].getValue());
          Date date = new Date(l);
          out.write("上一次访问的时间是：" + date.toLocaleString());
        }
      }
    }else {
      out.write("首次访问本网站");
    }

    // 服务端设置cookie
    Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
    cookie.setMaxAge(24*60*60);// 过期时间(s) -> 过期后该cookie将被删掉
    resp.addCookie(cookie);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
```