package cn.itcast.web;

import cn.itcast.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获取请求数据（用户id）
        String id = request.getParameter("id");
        // 2 带着用户id调用service
        UserService userService = new UserService();
        userService.delete(id);
        // 3 重定向到查询业务 查询最新数据展示
        response.sendRedirect(request.getContextPath() + "/find");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
