package com.tt.servlet;

import com.tt.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
