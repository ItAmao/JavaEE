package com.itamao.java.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/25 18:40
 */
@WebFilter("/*")
public class CodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request;
        HttpServletResponse response;
        try {
            request = (HttpServletRequest) req;
            response = (HttpServletResponse) resp;
        } catch (ClassCastException e) {
            throw new ServletException("non-Http request or response");
        }

        //处理post请求乱码
        request.setCharacterEncoding("UTF-8");
        //处理响应乱码
        response.setContentType("text/html;charset=UTF-8");
        //放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
