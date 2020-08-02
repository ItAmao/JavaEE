package cn.itcast.web;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Update1Servlet",urlPatterns = "/update1")
@SuppressWarnings("all")
public class Update1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接受页面的请求数据 （用户id）
        String id = request.getParameter("id");
        // 带着id调用service 获取一个user实体
        UserService userService = new UserService();
        User user=userService.findById(id);
        // 将user实体放入域中，带到页面展示
        request.setAttribute("user",user);
        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
