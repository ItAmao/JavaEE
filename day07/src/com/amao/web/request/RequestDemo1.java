package com.amao.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/16 14:28
 */

/**
 * 演示Request对象获取请求行数据
 */
@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求方式:GET
        String method = request.getMethod();
        System.out.println(method);// GET
        //2.获取虚拟目录:/day07(*) !important
        String contextPath = request.getContextPath();
        System.out.println(contextPath);// /day07
        //3.获取servlet路径: /demo1
        String servletPath = request.getServletPath();
        System.out.println(servletPath); // /requestDemo1
        //4.获取get方式的请求参数:name=xxx
        String queryString = request.getQueryString();
        System.out.println(queryString); //name=amao
        //5.1 获取请求的URI: /day07/demo1(*) !important
        String requestURI = request.getRequestURI();
        System.out.println(requestURI); // /day07/requestDemo1
        //5.2
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL); // http://localhost:8080/day07/requestDemo1
        //6.获取协议及版本:HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol); // HTTP/1.1
        //7.获取客户机的IP地址:
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);// 0:0:0:0:0:0:0:1 ipv6
    }
}
