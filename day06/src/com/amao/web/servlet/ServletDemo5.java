package com.amao.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/15 20:07
 */

/**
 * servlet路径配置
 */
//@WebServlet({"/d5", "/dd5", "/ddd5"})
//@WebServlet("/user/demo5")
//@WebServlet("/user/*") //表示/user/ 后边随便写啥都可以
//@WebServlet("/*")//优先级比较低,等别人找不到了,在来找他
@WebServlet("*.do") //表示以.do结尾的任意, 前边不能写/
public class ServletDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo5....");
    }
}
