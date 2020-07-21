package com.amao.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/19 16:58
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

        //1.获取input输入框
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        //2.先获取生成的验证码,已经存入了session先判断验证码是否正确
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //删除Session中验证码
        session.removeAttribute("checkCode_session");
        //不做处理的话 会报空指针异常,所以需要判断一下session是否为空
        //3.判断
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {
            //忽略大小写,比较字符串
            //验证码正确
            //判断用户名和密码是否一致
            if ("amao".equals(username) && "123".equals(password)) { //需要查询数据库
                //登录成功 重定向
                //存储信息,用户信息
                session.setAttribute("user", username);
                //重定向到success.jsp
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                //登录失败
                request.setAttribute("login_error", "用户名或密码错误");
                //请求转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            //验证码不一致,存储提示信息到request
            request.setAttribute("cc_error", "验证码错误");
            //请求转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
