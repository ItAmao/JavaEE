package com.amao.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/19 16:26
 *
 *  案例需求:
 *      1.访问带有验证码的登录页面 login.jsp
 *      2.用户输入用户名,密码以及验证码
 *          如果用户名和密码输入有误,跳转登录页面,提示:用户名或密码错误
 *          如果验证码输入有误,跳转登录页面,提示:验证码错误
 *          如果全部输入正确,则跳转到success.jsp,显示:用户名,欢迎你
 *
 *      3.分析:
 *          1.设置request的编码
 *          2.获取参数Map集合
 *          3.获取验证码
 *          4.将用户信息封装到User对象
 *          5.判断程序生成的验证码和用户输入的验证码是否一致,从session中获取程序生成的验证码
 *                  一致:
 *                      再判断用户名和密码是否正确
 *                          正确:
 *                              登录成功
 *                              存储数据 session
 *                              跳转到success.jsp 重定向
 *                          不正确:
 *                              1.给提示信息
 *                              2.跳转登录页面
 *                  不一致:
 *                      1.给用户提示信息:验证码错误 request
 *                      2.跳转登录页面 转发
 *          6.显示错误信息,从request域中获取
 *
 */
@WebServlet("/CheckCodeSession")
public class CheckCodeSession extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
    }
}
