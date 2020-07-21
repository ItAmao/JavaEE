package com.amao.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/20 17:51
 */
@WebServlet("/twoServlet")
public class TwoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.获取cookie数据
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            response.getWriter().println("没有数据");
        } else {
            for (Cookie cookie : cookies) {
                response.getWriter().println(cookie.getName() + ":" + cookie.getValue());
            }
        }
    }
}
