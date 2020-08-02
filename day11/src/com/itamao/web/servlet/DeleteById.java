package com.itamao.web.servlet;

import com.itamao.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/23 21:59
 */
@WebServlet("/deleteById")
public class DeleteById extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.获取信息
        String uid = request.getParameter("uid");

        //2.调用UserService方法
        UserService userService = new UserService();
        userService.deleteById(uid);

        //3.
        response.sendRedirect("findAllServlet");
    }
}
