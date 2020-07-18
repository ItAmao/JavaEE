package com.amao.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/17 20:49
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取文本框的值
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        if (username == null && password == null && phone == null) {
            
        }

        //2.把值写进文本中
        FileOutputStream fos = new FileOutputStream(new File("/Users/mao/Documents/code/JavaEE/day07_2/student.txt"), true);
        String content = "username:" + username + ", password:" + password + ", phone:" + phone;
        fos.write(content.getBytes());
        fos.write("\t\n".getBytes());

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(new File("/Users/mao/Documents/code/JavaEE/day07_2/student.txt"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
    }
}
