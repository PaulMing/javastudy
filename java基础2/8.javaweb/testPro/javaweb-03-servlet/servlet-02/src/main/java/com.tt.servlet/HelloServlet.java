package com.tt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            this.xxx 学习几个常用方法

            servletContext: web容器在启动时会为每个web程序创建一个对应的上下文对象，其表示的就是当前web应用

            共享数据:
            各个servlet数据共享

            获取初始化参数：
            web.xml配置初始化参数

            请求转发 -> url不会改变，重定向才会改变，重定向是后端直接将请求url做了修改
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/share");//转发的请求路径
            requestDispatcher.forward(req,resp);//调用forward实现请求转发







        */
        System.out.println("servlet调用成功");
        ServletContext context = this.getServletContext();
        String username = "共享value";
        context.setAttribute("username",username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}