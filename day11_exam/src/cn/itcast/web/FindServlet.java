package cn.itcast.web;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindServlet",urlPatterns = "/find")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service查询用户数据
        UserService userService = new UserService();
        List<User> list=userService.find();
        // 将数据保存在request域中，带到list.jsp页面展示
        request.setAttribute("list",list);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
