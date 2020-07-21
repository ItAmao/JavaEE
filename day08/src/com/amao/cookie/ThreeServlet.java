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
 *  @Date   : 2020/7/20 18:01
 */
@WebServlet("/threeServlet")
public class ThreeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.创建cookie对象
        Cookie cookie = new Cookie("msg", "ItAmao");

        //2.cookie的设置 最大年龄 (cookie的生产时间 单位:秒)
        cookie.setMaxAge(60 * 60 * 24);

        /*
            cookie.setPath(""); 设置cookie的访问路径
            如果设置路径后,以后访问服务器的路径和设置路径一样 会自动携带cookie(子路径也会携带cookie)
            cookie 路径设置一般为/
         */
        cookie.setPath("/");

        //3.响应cookie
        response.addCookie(cookie);
    }
}
