package com.itamao.java.web.servlet;

import com.itamao.java.domain.User;
import com.itamao.java.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/31 21:02
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private static UserService userService = new UserService();

    public void register(HttpServletRequest request, HttpServletResponse response) {
        //1.获取用户信息
        Map<String, String[]> map = request.getParameterMap();
        //2.创建对象
        User user = new User();
        //3.封装对象
        try {
            BeanUtils.populate(user, map);
            userService.insertUser(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获取用户信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.获取到用户名和密码,发送给service
        boolean isExist = userService.loginUser(username, password);
        if (isExist) {
            response.getWriter().println("登录成功");
        }else {
            response.getWriter().println("登录失败");
        }
    }
}
