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
 *  @Date   : 2020/7/19 09:50
 *  cookie的快速入门
 */
@WebServlet("/cookie03")
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.创建两个cookie,相当于键值对 键不能重复
        Cookie c1 = new Cookie("company", "hnItAmao");
        Cookie c2 = new Cookie("company1", "shItAmao");

        //指定cookie绑定的路径
        //c1.setPath("");

        //2.向响应中添加cookie
        response.addCookie(c1);
        response.addCookie(c2);


    }
}
