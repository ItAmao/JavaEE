package com.itamao.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/22 08:34
 */
@WebFilter("/*")
public class FilterDemo3 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息增强
        System.out.println("filterDemo3....");
        //放行
        chain.doFilter(req, resp);
        //回来之后,对response的响应消息增强
        System.out.println("filterDemo3回来了....");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
