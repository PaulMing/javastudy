package com.tt.filter;

import javax.servlet.*;
import java.io.IOException;

/*
    过滤器使用：
       1.需实现Filter接口[javax.servlet.*,不要导错了]
       2.重写方法
         init();//初始化
         doFilter();//过滤函数
         destroy();//销毁
*/
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 服务器启动时初始化 -> 通过filterConfig参数操作一些事项
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter执行前");
        // 处理乱码
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");//指定服务器响应给浏览器的编码 && 浏览器会根据该值对接收到的数据进行编码(解码)
        // filterChain.doFilter(servletRequest,servletResponse); 请求继续往下走，不写默认拦截
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filter执行后");
    }

    @Override
    public void destroy() {
        // 服务器关闭时销毁
        System.out.println("销毁");
    }
}