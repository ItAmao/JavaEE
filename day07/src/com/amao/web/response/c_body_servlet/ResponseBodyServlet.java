package com.amao.web.response.c_body_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/18 23:14
 */
@WebServlet("/responseBodyServlet")
public class ResponseBodyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
        /**
         * ​	字节流: 输出文件 视频 音频 图片...(1节课)
         *       ServletOutputStream outputStream = response.getOutputStream();
         * ​	字符流: 输出文字信息(简单)
         *      PrintWriter writer = response.getWriter(); 字符流
         *  无论是字节流还是字符流
         *      api: writer(内容)
         */
        //content 内容-type 类型 : 设置返回的内容的类型  大类型/小类型  text/css  text/javascript
        //返回的数据是文本 , 并且按照html语法解析 charset=utf-8 字符集编码
        response.setHeader("content-type" , "text/html;charset=utf-8");//缓存区的效果
        //只要写servlet 头两句话 处理请求编码和响应编码
        PrintWriter writer = response.getWriter();
        writer.write("a");
        writer.write("<a href='xxxx'>百度</a>");
        writer.write("c");
    }
}
