package com.amao.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/16 20:05
 */
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //这是已经知道浏览器和客户端使用的什么编码格式
        //response.setCharacterEncoding("utf-8");
        //所以还需要告诉浏览器,服务器发送的消息体数据的编码,,建议浏览器使用该编码
       // response.setHeader("content-type", "text/html;charset=utf-8");

        //简单的形式来设置代码
        response.setContentType("text/html;charset=utf-8");

        //1.获取字符输出流
        PrintWriter pw = response.getWriter();
        //2.输出数据
        //pw.write("<h1>Hello, response</h1>");

        //中文乱码问题
        //1.乱码的原因:编解码使用的字符集不一致 浏览器默认GBK(gb2312) 获取的流对象是tomcat编码是拉丁编码
        //解决乱码 在获取流对象之前来设置编码格式
        pw.write("你好阿毛");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
