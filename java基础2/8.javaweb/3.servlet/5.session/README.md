## session
> 存储在服务端 -> 每个用户访问服务器，服务器都会通过setCookie的方式在客户端创建sessionId，也就是每个用户唯一标识，每个用户都是唯一的session对象，通过该对象完成用户身份信息存储等 => 每种浏览器仅代表一个用户，并不是窗口[新开的无痕窗口也算新浏览器]，session聚焦'每个用户'
> 其常用于存储：用户身份信息、购物车信息等 -> 避免服务端存储数据压力大

```java
package com.tt.servlet;
import com.tt.pojo.Person;

public class SessionDemo1 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("测试Session1");
    // 解决中文乱码
    req.setCharacterEncoding("utf-8");
    resp.setCharacterEncoding("utf-8");
    resp.setContentType("text/html;charset=utf-8");

    // 获取session
    HttpSession session = req.getSession();
    session.setAttribute("name","kkk");
    session.setAttribute("test",new Person("curry",18));
    String id = session.getId();

    if(session.isNew()) {
      resp.getWriter().write("session创建成功，ID:" + id);
    }else {
      resp.getWriter().write("session已经存在，ID:" + id);
    }

    // 注销session
    // session.invalidate();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
```