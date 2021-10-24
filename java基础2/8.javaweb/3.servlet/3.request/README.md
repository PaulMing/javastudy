## request
> 其表示客户端的请求，请求信息相关接口都被封装到HttpServletRequest

```java
package com.tt.servlet;

public class LoginServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 请求转发

    req.setCharacterEncoding("utf-8");// 处理"收到请求后的乱码"
    resp.setCharacterEncoding("utf-8");// 处理"客户端展示的乱码"
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String[] keys = req.getParameterValues("key");
    System.out.println(username);
    System.out.println(password);
    System.out.println(keys.toString());
    req.getRequestDispatcher("/success.jsp").forward(req,resp);//路径/表示当前web应用
    // req.getRequestDispatcher(req.getContextPath() + "/success.jsp").forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
```