package com.tt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("获取资源文件");
        ServletContext context = this.getServletContext();
        // 读取资源：1.new properties();  2.load(流)
        // 资源文件目录：main/resources下创建资源，打包后的路径target/classes/xx.properties，classes目录也称之为classpath
        InputStream stream = context.getResourceAsStream("/WEB-INF/classes/db.properties");//路径：项目构建后的路径
        Properties prop = new Properties();
        prop.load(stream);
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print(username + ":" + password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}