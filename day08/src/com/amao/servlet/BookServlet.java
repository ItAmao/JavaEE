package com.amao.servlet;

import com.amao.db.InitDB;
import com.amao.domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/20 19:45
 */
@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.获取id的值
        String id = request.getParameter("id");
        //System.out.println(id);

        //2.获取cookie
        Cookie[] cookies = request.getCookies();
        String cookiesValue = null; //临时定义一个cookie的值,默认为null
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //id 为cookie的键,意思是,表示cookie里边存在id这个键
                if ("id".equals(cookie.getName())) {
                    cookiesValue = cookie.getValue();
                }
            }
        }
        String ids = id;
        if (cookiesValue != null) {
            //表示不是第一次访问
            ids = ids + "-" + cookiesValue;
        }
        //存储cookie
        Cookie cookie = new Cookie("id", ids);
        cookie.setPath("/");
        cookie.setMaxAge(100);
        response.addCookie(cookie);

//        System.out.println(id);
//        System.out.println(ids);
        //读取map
        Book book = InitDB.getBookById(id);
        response.getWriter().println("您此次查看的书籍是:  " + book);

    }
}
