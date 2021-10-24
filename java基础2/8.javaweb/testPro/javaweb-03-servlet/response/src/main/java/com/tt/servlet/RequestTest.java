package com.tt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get请求进入");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + ":" + password);

        /*
            重定向：
               -> 底层实现：1.设置'客户端请求的url' 2.设置响应状态码;//客户端拿到302状态码会自动跳转
               resp.setHeader("location",'/s3/success.jsp');
               resp.setStatus(302);
        */
        resp.sendRedirect("/s3/success.jsp");//语法糖：客户端设置新url + 响应状态码
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}