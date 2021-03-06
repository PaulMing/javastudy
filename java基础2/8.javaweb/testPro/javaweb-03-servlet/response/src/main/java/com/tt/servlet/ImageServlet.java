package com.tt.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 应用：浏览器校验码

        // 浏览器3s自动刷新
        resp.setHeader("refresh","3");

        // 1.创建图片
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        // 2.画笔
        Graphics2D g = (Graphics2D) image.getGraphics();
        // 3.设置背景色
        g.setColor(Color.white);
        g.fillRect(0,0,80,20);
        // 4.写数据
        g.setColor(Color.BLUE);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(makeNum(),0,20);

        // 5.设置：通知浏览器使用图片形式打开
        resp.setContentType("image/jpeg");
        // 6.设置：浏览器不要缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        // 7.图片发送给浏览器
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    // 生成随机数
    private String makeNum() {
        Random random = new Random();
        String num = random.nextInt(9999999) + "";
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<7-num.length(); i++) {
            sb.append("0");
        }
        num = sb.toString() + num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
