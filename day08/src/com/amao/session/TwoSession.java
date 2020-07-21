package com.amao.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/20 20:31
 */
@WebServlet("/twoSession")
public class TwoSession extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.取
        System.out.println("TwoSession 取");

        HttpSession session = request.getSession();
        System.out.println("地址:" +  session );
        System.out.println("id:" +  session.getId() );
        System.out.println("是不是新创建的对象:" +  session.isNew() );
        Object ds = session.getAttribute("ds");
        System.out.println("session中存储的数据为:" + ds);

    }
}
