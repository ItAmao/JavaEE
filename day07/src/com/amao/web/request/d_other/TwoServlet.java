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
@WebServlet("/two")
public class TwoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("TwoServlet");
        //获取值
        Object ds = request.getAttribute("ds");
        //Object dzd = request.getAttribute("dzd");
        //不能按照以上的方法获取
        Object dzd = getServletContext().getAttribute("dzd");
        System.out.println(ds);
        System.out.println(dzd);
    }
}
