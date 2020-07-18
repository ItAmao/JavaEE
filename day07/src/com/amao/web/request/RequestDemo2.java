package com.amao.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/16 14:28
 */

/**
 * 演示Request对象获取请求行数据
 */
@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据

        //1.获取所有请求头名称
        Enumeration<String> headerName = request.getHeaderNames();
        //2.遍历
        while (headerName.hasMoreElements()) {
            String name = headerName.nextElement();
            //根据名称来获取请求头的值
            String value = request.getHeader(name);
            System.out.println(name + "---" + value);
        }
    }
}