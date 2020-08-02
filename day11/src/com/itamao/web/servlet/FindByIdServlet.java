package com.itamao.web.servlet;

import com.itamao.java.domain.User;
import com.itamao.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/23 21:20
 */
@WebServlet("/findByIdServlet")
public class FindByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.获取请求参数
        String uid = request.getParameter("uid");
        System.out.println(uid);
        //2.调用业务逻辑
        UserService userService = new UserService();
        User user = userService.findById(uid);

        //3.分发转向
        request.setAttribute("user", user);
        request.getRequestDispatcher("edit.jsp").forward(request, response);

    }
}
