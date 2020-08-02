package com.itamao.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器快速入门
 *
 *  @Author : ItAmao
 *  @Date   : 2020/7/22 07:57
 */
public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo1被执行了....");

        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
