package com.tt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 后台接收中文乱码问题
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] keys = req.getParameterValues("key");
        System.out.println(username);
        System.out.println(password);
        System.out.println(keys.toString());

        // 请求转发
        resp.setCharacterEncoding("utf-8");
        // 路径/表示当前web应用
        req.getRequestDispatcher("/success.jsp").forward(req,resp);
//        req.getRequestDispatcher(req.getContextPath() + "/success.jsp").forward(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
