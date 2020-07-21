package com.amao.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/19 15:48
 */
@WebServlet("/sessionDemo4")
public class SessionDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //使用session共享数据

        //1.获取session
        HttpSession session = request.getSession();
        //期望客户端关闭后,session也能相同
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        System.out.println(session);//打印的是Session的hashCode值

    }
}
