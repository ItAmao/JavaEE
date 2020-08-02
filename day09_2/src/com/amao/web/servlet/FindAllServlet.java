package com.amao.web.servlet;

import com.amao.domain.User;
import com.amao.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/21 17:03
 */
@WebServlet("/findAll")
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

        //1.获得浏览器数据


        //2.处理数据
        //2.1创建service的对象
        UserService userService = new UserService();
        //2.2调用方法查询数据
        List<User> userList = userService.findAll();
        //3.响应结果
        // System.out.println("userList" + userList);

        //3.1servlet需要保存数据
        request.setAttribute("userList", userList);

        //3.2请求转发找jsp
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
