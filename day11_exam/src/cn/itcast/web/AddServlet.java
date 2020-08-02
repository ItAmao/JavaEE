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

@WebServlet(name = "AddServlet",urlPatterns = "/add")
@SuppressWarnings("all")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //1 获取页面的请求数据 map
            Map<String, String[]> map = request.getParameterMap();
            //2 使用BeanUtils工具将map的数据封装给User实体
            User user=new User();
            BeanUtils.populate(user,map);
            //3 调用service传递封装好的实体user对象
            UserService userService = new UserService();
            userService.add(user);
            //4 重定向查询业务 查询最新数据
           response.sendRedirect(request.getContextPath()+"/find");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
