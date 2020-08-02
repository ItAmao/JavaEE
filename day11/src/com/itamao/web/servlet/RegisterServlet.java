package com.itamao.web.servlet;

import com.itamao.java.domain.User;
import com.itamao.service.UserService;
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
 *  @Date   : 2020/7/22 13:20
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.获取注册表单的值
        Map<String, String[]> map = request.getParameterMap();
        //2.创建对象
        User user = new User();
        try {
            //3.调用工具包
            BeanUtils.populate(user, map);
            //4.调用service里边的add方法
            UserService userService = new UserService();
            userService.add(user);
            //转向
            response.sendRedirect("findAllServlet");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
