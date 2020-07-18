package com.amao.web.request.b_requestHeader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/18 20:48
 */
@WebServlet("/refererHeaderServlet")
public class RefererHeaderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println(  request.getHeader("referer")  );
        //获得当前访问资源的上一个链接
        String referer = request.getHeader("referer");
        if("http://localhost:8080/day07/form2.html".equals(referer)){
            System.out.println("自己网站的资源访问");
        }else{
            System.out.println("钓鱼网站 请修改密码");
            return ;
        }
    }
}
