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
@WebServlet("/cookie04")
public class CookieDemo04 extends HttpServlet {
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

        //2,设置cookie的存活时间
        //2.1将cookie持久化到硬盘 ,10s后会自动删除文件
        //2.2正数
        //c1.setMaxAge(10);

        //负数 默认值
        //c1.setMaxAge(-1);

        //0; 表示删除cookie
        //c1.setMaxAge(0);


        //2.向响应中添加cookie
        response.addCookie(c1);


    }
}
