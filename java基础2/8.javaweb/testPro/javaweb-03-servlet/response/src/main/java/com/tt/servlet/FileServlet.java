package com.tt.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取下载文件的路径
        String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/mvn.png");
//        String realPath = "C:\\workspace\\dev\\1.技术体系\\2.后端\\javastudy\\java基础2\\8.javaweb\\testPro\\javaweb-03-servlet\\response\\src\\main\\resources\\mvn.png";
        System.out.println(realPath);
        // 下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        System.out.println(fileName);
        // 设置 浏览器可支持下载内容
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));//URLEncoder.encode(fileName,"utf-8") 文件名转码
        // 获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        // 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        // 获取输出流对象
        ServletOutputStream out = resp.getOutputStream();
        //
        while((len=in.read(buffer)) > 0) {
            out.write(buffer,0,len);
        }

        in.close();
        out.close();




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}