package com.itamao.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AServlet", urlPatterns = "/addCartServlet")
public class AddCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获得选择的商品是谁
        String name = request.getParameter("name");

        //解决问题的代码, 获得原来的购物车对象
        Map<String, Integer> cart = (Map) request.getSession().getAttribute("cart");

        Integer count = null; //代表的是商品数量

        //判断该用户是否有购物车 并且购物车中是否已经买过同类的商品
        if (cart == null) {
            //如果用户没有买过商品 没有购物车新创建一个 并且数量赋值为1
            cart = new HashMap<String, Integer>();
            count = 1;//初始化用户买的数量
        } else {

            if (count == null) {
                // 说明购物车中无此商品 初始化数量+1
                count = 1;
            } else {
                // 如果有此商品，将数量加1
                count += 1;
            }
        }
        //加入购物车
        cart.put(name, count);

        //将数据放入到session中  cart 购物车
        request.getSession().setAttribute("cart", cart);

        //输出结果
        response.getWriter().print(name + "加入购物车成功");
    }
}