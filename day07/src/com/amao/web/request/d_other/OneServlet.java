package com.amao.web.request.d_other;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/18 21:35
 */
@WebServlet("/one")
public class OneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //请求转发
        /*
            请求转发的特点:1.一次请求  2.url地址栏不会发生变化  3站内访问   4.携带数据
         */
        request.setAttribute("ds", "你好");

        getServletContext().setAttribute("dzd", "世界");

        //请求转发
        //第一个参数是 转发到的Servlet
        request.getRequestDispatcher("two").forward(request, response);

    }
}
