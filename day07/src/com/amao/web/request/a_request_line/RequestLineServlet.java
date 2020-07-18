package com.amao.web.request.a_request_line;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/18 19:37
 */
@WebServlet("/requestLineServlet")
public class RequestLineServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    //service是生命周期的方法,HttpServlet,将请求一分为7,自己的servlet只需要重写具体的doXxx方法,由父类进行调用
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        /*
        1.虚拟名称路径
        2.请求方式
        3.远程主机的ip地址(获得客户端的IP地址)
        ---------------------------------------------------------
        4.获得协议
        5.获取域名,使用localhost或者IP地址--->服务器名字
        6.获取端口号
        7.访问资源名称
        8.获取参数
        9.获取路径
            1.统一资源定位符(绝对路径)
            2.统一资源描述符(相对路径)
        */

        //1.虚拟名称路径
        String contextPath = request.getContextPath();
        System.out.println(contextPath);// /day07

        //2.请求方式
        String method = request.getMethod();
        System.out.println(method); //GET

        //3.远程主机ip地址(获取客户端的ip地址)
        int remotePort = request.getRemotePort();
        System.out.println(remotePort);

        //4.获取协议
        String scheme = request.getScheme();
        System.out.println(scheme); //http

        //5.获取域名,使用localhost或者IP地址--->服务器名字
        String serverName = request.getServerName();
        System.out.println(serverName); //localhost

        //6.获取端口号
        int serverPort = request.getServerPort();
        System.out.println(serverPort); //8080

        //7.访问资源名称
        String servletPath = request.getServletPath();
        System.out.println(servletPath); ///requestLineServlet

        //8.获取参数
        String queryString = request.getQueryString();
        System.out.println(queryString); //username=111&password=111

        //9.获取路径
        //1.统一资源定位符(绝对路径)
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL); //http://localhost:8080/day07/requestLineServlet

        //2.统一资源描述符(相对路径)
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);  ///day07/requestLineServlet
    }
}
