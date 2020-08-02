package cn.itcast.web;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "Update2Servlet",urlPatterns = "/update2")
@SuppressWarnings("all")
public class Update2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            // 获取请求数据  map
            Map<String, String[]> map = request.getParameterMap();
            // beanUtils将map的数据给实体user
            User user = new User();
            BeanUtils.populate(user,map);
            // 带着user调用service
            UserService userService = new UserService();
            userService.update(user);
            // 重定向到查询业务 查询最新的数据展示
            response.sendRedirect(request.getContextPath()+"/find");
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
