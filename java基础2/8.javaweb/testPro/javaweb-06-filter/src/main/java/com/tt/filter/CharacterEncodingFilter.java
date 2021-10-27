package com.tt.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 服务器启动时初始化 -> 通过filterConfig操作一些事项
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter执行前");
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");//指定服务器响应给浏览器的编码 && 浏览器会根据该值对接收到的数据进行编码(解码)
        // chain.doFilter(servletRequest,servletResponse); 请求继续往下走，不写默认拦截
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filter执行后");
    }

    @Override
    public void destroy() {
        // 服务器关闭时销毁
        System.out.println("销毁");
    }
}