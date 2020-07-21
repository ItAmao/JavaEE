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
 *  案例需求:
 *      1.访问一个Servlet,如果是第一次访问,则提示,你好:欢迎您首次访问
 *      2.如果不是第一次访问,则提示:欢迎回来,您上次访问的时间为:显示时间字符串
 *
 *     分析: 可以采用cookie来完成
 *      1.可以采用cookie来完成
 *      2.在服务器中的servlet判断是否有一个名为lastTime的cookie
 *      3.有:表示不是第一次来的, 响应数据:您上次访问的时间为.... 写回cookie
 *      4.没有:表示第一次来的   响应数据:你好,欢迎您首次访问  写回cookie
 *
 */
@WebServlet("/cookie05")
public class CookieDemo05 extends HttpServlet {
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
