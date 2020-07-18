package com.amao.web.response.b_header_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/18 22:51
 */
@WebServlet("/one1")
public class OneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("OneServlet");
        //response.setStatus(302);//设置状态码
        //response.setHeader("location" , "http://localhost:8080/day01/twoServlet");
        //服务器上缩写:  http://localhost:8080 可省略
        //response.setHeader("location" , "/day07/twoServlet"); //uri

        request.setAttribute("ds", "xxxx"); //存入了域
        //重定向可以站内 也可以站外 /day01必须加
        response.sendRedirect("/day07/two1"); //重定向的缩写 内置状态码 和 location
        //response.sendRedirect("https://www.baidu.com/"); //重定向的缩写 内置状态码 和 location

        //默认只是自己网站的内部 默认加上/day07
        //request.getRequestDispatcher("twoServlet").forward(request, response);

/**
 * 源码:
 * public void sendRedirect(String path){
 *     response.setStatus(302);//设置状态码
 *     response.setHeader("location" , path);
 * }
 */
    }
}
