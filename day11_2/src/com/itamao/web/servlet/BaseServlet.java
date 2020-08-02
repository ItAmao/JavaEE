package com.itamao.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/25 18:38
 *
 *  抽取基类减少servlet数量
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求路径
        String uri = req.getRequestURI();
        //System.out.println(uri); ///day11_2/user
        //2.获取方法名称
        String methodName = uri.substring(uri.lastIndexOf('/') + 1);
        //System.out.println(methodName);
        if (methodName.endsWith(".jsp")) {
            return ;
        }
        //3.获取方法对象Method
        //ps:这里的this表示的是谁调用就是谁
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //4.执行方法
            System.out.println(method);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}