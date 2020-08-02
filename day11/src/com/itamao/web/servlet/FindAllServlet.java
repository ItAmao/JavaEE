package com.itamao.web.servlet;

import com.itamao.java.domain.User;
import com.itamao.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/23 19:50
 */
@WebServlet("/findAllServlet")
public class FindAllServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.调用业务逻辑
        UserService userService = new UserService();
        List<User> list = userService.findAll();

        //2.分发转向
        request.setAttribute("list", list);
        request.getRequestDispatcher("/list.jsp").forward(request, response);

        System.out.println(1);
    }
}
