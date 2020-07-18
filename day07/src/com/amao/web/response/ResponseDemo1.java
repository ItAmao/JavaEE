package com.amao.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 完成重定向
 *
 *  @Author : ItAmao
 *  @Date   : 2020/7/16 20:05
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("demo1......");

        request.setAttribute("msg", "response");
        //访问/responseDemo1,会自动跳转到/responseDemo2这个资源
        //1.设置状态码为302
//        response.setStatus(302);
//        //2.设置响应头location
//        response.setHeader("location", "/day07/responseDemo2");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        //简单的重定向方法
        response.sendRedirect("/day07/responseDemo2");
        //response.sendRedirect("http://www.baidu.com");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
