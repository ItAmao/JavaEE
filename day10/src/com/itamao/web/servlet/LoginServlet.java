package com.itamao.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/23 12:24
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.获取form表单的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String isauto = request.getParameter("isauto");

        //2.判断用户名密码是否正确


        //3.如果需要自动登录,把用户名和密码数据存入cookie



        //4.用户名密码不正确,把请求转发到登录页面
    }
}
