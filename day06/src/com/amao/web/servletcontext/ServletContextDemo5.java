package com.amao.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/16 22:22
 */
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * ServletContext对象的功能:
         *      1.获取MIME类型:
         *         2.域对象:共享数据
         *         3.获取文件的真实路径
         */
        //1.通过HTTPServlet获取
        ServletContext context = this.getServletContext();
        //2.获取文件真实的服务器路径
        String b = context.getRealPath("/b.txt"); // web目录下资源访问
        System.out.println(b);// /Users/mao/Documents/code/JavaEE/out/artifacts/day07_war_exploded/b.txt
        //File file = new File(realPath);

        String c = context.getRealPath("WEB-INF/c.txt"); //WEB-INF目录下的资源访问
        System.out.println(c);///Users/mao/Documents/code/JavaEE/out/artifacts/day07_war_exploded/WEB-INF/c.txt

        String a = context.getRealPath("WEB-INF/classes/a.txt");
        System.out.println(a);///Users/mao/Documents/code/JavaEE/out/artifacts/day07_war_exploded/WEB-INF/classes/a.txt

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
