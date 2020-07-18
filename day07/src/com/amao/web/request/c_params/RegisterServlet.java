package com.amao.web.request.c_params;


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
 *  @Date   : 2020/7/18 21:07
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        try {
            //获取浏览器的所有请求参数
            Map<String, String[]> map = request.getParameterMap();
            //创建User
            User user = new User();
            /**
             * BeanUtils.populate(user , map);
             * 快速封装数据
             *  将参数2的map数据 封装到 参数的对象中
             *  封装是有条件:
             *  表单的name属性 跟 实体类中的set方法一致(去掉set首字母小写)
             *  找得到就封装 找不到就不封装
             */
            BeanUtils.populate(user, map);
            System.out.println(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
