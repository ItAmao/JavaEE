package com.amao.web.request.b_requestHeader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/18 20:27
 */
@WebServlet("/requestHeaderServlet")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //请求头的key 不区分大小写
        String value1 = request.getHeader("User-Agent");
        String value2 = request.getHeader("user-agent");
        String value3 = request.getHeader("user-Agent");
        String value4 = request.getHeader("User-agent");
        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
        System.out.println(value4);
        //获得所有的请求头名称
        //Enumeration 迭代器前身
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            System.out.println(headerNames.nextElement());
        }

    }
}
