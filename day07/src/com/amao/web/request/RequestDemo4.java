package com.amao.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/16 14:28
 */

/**
 * 演示Request对象获取请求行数据
 */
@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据:referer
        //从哪儿来
        String referer = request.getHeader("referer");
        //System.out.println(referer); //null 直接访问 获取不到
        //http://localhost:8080/day07/login.html

        //防盗链
        if (referer != null) {
            if (referer.contains("/day07")) {
                //正常访问
                //System.out.println("播放电影");
                //写到页面
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影");
            } else {
                //盗链
                //System.out.println("想看电影吗?来爱奇艺吧....");
                //写到页面
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("想看电影吗?来爱奇艺吧....");
            }
        }


    }
}
