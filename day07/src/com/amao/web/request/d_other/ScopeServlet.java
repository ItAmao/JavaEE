package com.amao.web.request.d_other;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/18 21:36
 */
@WebServlet("/scopeServlet")
public class ScopeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //1.获取数据
        Object ds = request.getAttribute("ds");
        System.out.println(ds);

        //2.赋值数据
        request.setAttribute("ds", "ItAmaon你好");

        //3.获取数据
        Object ds1 = request.getAttribute("ds");
        System.out.println(ds1);

        //4删除属性
        request.removeAttribute("ds");

        Object ds2 = request.getAttribute("ds");
        System.out.println(ds2);

    }
}
