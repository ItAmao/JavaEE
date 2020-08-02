package com.itamao.web.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/24 16:07
 *
 *  文件上传的注解
 *  MultipartConfig
 *  已经解析了request对象,并重新封装
 */
@WebServlet("/upload2Servlet")
@MultipartConfig
public class Upload2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.获取数据 Part 文件上传对象,支持批量上传
        Part part = request.getPart("MyFile");
        if (part.getSize() > 0) {
            //表示对象里边数据不为空
            String name = part.getName(); //myFile input的name属性

            String submittedFileName = part.getSubmittedFileName();//文件名称
            //2.1获得输入流
            InputStream is = part.getInputStream();
            //2.2获得输出流
            String path = "/Users/mao/Desktop/test";
            //String realPath = getServletContext().getRealPath("/test");
            FileOutputStream os = new FileOutputStream(path + "/" + submittedFileName);

            IOUtils.copy(is, os);
            is.close();
            os.close();
            response.sendRedirect("start2.html");
        }
    }
}
