package com.amao.web.response.b_header_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/18 23:06
 */
@WebServlet("/refreshServlet")
public class RefreshServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("定时刷新代码执行" + new Date().toLocaleString()); //将日期转换成字符串
        /**
         * 定时刷新 :
         *  语法:
         *      秒   : 定时刷新本网页
         *      秒;url="地址"  定时跳转某个页面(都交给前端做了)
         */
        response.setHeader("refresh", "1;url=https://www.baidu.com/");
    }
}
