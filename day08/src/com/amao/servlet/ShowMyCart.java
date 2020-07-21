package com.amao.servlet;

import com.amao.domain.Book;

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
 *  @Date   : 2020/7/20 21:04
 */
@WebServlet("/showMyCart")
public class ShowMyCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获得购物车对象
        Map<String, Book> cart = (Map) request.getSession().getAttribute("shopCar");

        //遍历

        if (cart != null) {
            for (Map.Entry<String, Book> entry : cart.entrySet()) {
                response.getWriter().print("购物车中的数据为: " + entry.getValue() + " <br/>");
            }
        } else {
            response.getWriter().print("您的购物车空空如也");
        }


    }
}
