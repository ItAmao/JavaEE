package com.itamao.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/22 08:34
 */
//@WebFilter("/*")
public class FilterDemo4 implements Filter {
    /**
     * 在服务器关闭后filter对象被销毁,如果服务器是正常关闭,则会执行destroy方法
     * 作用:用于释放资源
     */
    public void destroy() {
        System.out.println("destroy...");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo4....");
        //放行
        chain.doFilter(req, resp);

    }

    /**
     * 在服务器启动后,会创建filter对象,调用init方法,只执行一次,
     * 作用:用于加载资源
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init....");
    }

}
