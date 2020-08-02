package com.itamao.web.servlet;

import com.itamao.java.domain.User;
import com.itamao.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/25 18:39
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserService();

    /**
     * 添加用户
     * @param request
     * @param response
     */
    public void register(HttpServletRequest request, HttpServletResponse response) {
        //1.获取用户信息
        Map<String, String[]> map = request.getParameterMap();
        //2.创建对象
        User user = new User();
        //3.封装对象
        try {
            BeanUtils.populate(user, map);
            boolean register = userService.register(user);
            response.sendRedirect(request.getContextPath() + "/findAllServlet");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改用户信息
     * @param request
     * @param response
     */
    public void update(HttpServletRequest request, HttpServletResponse response) {
        //获取修改的用户信息
        Map<String, String[]> map = request.getParameterMap();
        //创建User对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }

    /**
     * 通过id查找用户
     * @param request
     * @param response
     */
    public void findById(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        //System.out.println(id);
        User user = userService.findOne(id);
        System.out.println(user);
        if (user != null) {
            request.setAttribute("user", user);
            try {
                request.getRequestDispatcher("update.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
