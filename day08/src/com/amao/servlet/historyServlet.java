package com.amao.servlet;

import com.amao.db.InitDB;
import com.amao.domain.Book;
import com.sun.org.apache.xml.internal.security.Init;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/20 19:49
 */
@WebServlet("/historyServlet")
public class historyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.获取cookie
        Cookie[] cookies = request.getCookies();
        String cookiesValue = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //判断cookie是否包含键值
                if ("id".equals(cookie.getName())) {
                    cookiesValue = cookie.getValue();
                }
            }
        }

        //获取访问历史记录
        if (cookiesValue != null) {
            //说明有历史记录
            String[] split = cookiesValue.split("-");
            response.getWriter().println("<font color='red'>历史访问记录为:</font>");
            response.getWriter().println("</br>");
            for (String s : split) {
                //从map中获取图书信息
                Book book = InitDB.getBookById(s);
                response.getWriter().println(book);
                response.getWriter().println("</br>");
            }
        } else {
            response.getWriter().println("<h1>您没有访问记录</h1>");
        }
    }
}
