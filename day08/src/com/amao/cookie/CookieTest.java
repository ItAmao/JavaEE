package com.amao.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/19 13:52
 *
 *  1.用户访问浏览器,如果是第一次访问,则显示  首次访问 然后记录访问的时间
 *  2.当用户
 */
@SuppressWarnings("all")
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.获取所有的cookie
        Cookie[] cookies = request.getCookies();
        String cookieValue = null;//初始中间值,默认为空
        //2.判断cookies是否为空
        //2.1 如果cookies不为空
        if (cookies != null) {
            //2.2,遍历cookie,找到对应的值
            for (Cookie cookie : cookies) {
                if ("lastTime".equals(cookie.getName())) {
                    //2.3表示,不是第一次访问,取出存取的时间
                    cookieValue = cookie.getValue();
                }
            }
        }
        if (cookieValue != null) {
            //2.第N次访问
            System.out.println("解码前的时间:" + cookieValue);
            String decode = URLDecoder.decode(cookieValue, "utf-8");
            response.getWriter().println("您上一次访问的时间为: " + decode);

            //3.获取访问时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formateDate = sdf.format(new Date());
            //3.1 因为再tomcat8之后,虽然支持了中文,但是不支持特殊字符,在日期的时候,设置了空格,所以加入cookie的时候会报500错误
            //3.2这个时候 ,就需要对数据 进行编解码的操作
            System.out.println("编码前:" + formateDate);
            String encode = URLEncoder.encode(formateDate, "utf-8");
            System.out.println("编码后:" + encode);
            Cookie cookie = new Cookie("lastTime", encode);
            cookie.setMaxAge(60 * 60 * 24 * 7);
            cookie.setPath("/");
            response.addCookie(cookie);
        } else {
            //第一次访问
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formateDate = sdf.format(new Date());
            //3.1 因为再tomcat8之后,虽然支持了中文,但是不支持特殊字符,在日期的时候,设置了空格,所以加入cookie的时候会报500错误
            //3.2这个时候 ,就需要对数据 进行编解码的操作
            //URL编码   URLEncoder  URLDecoder
            String encode = URLEncoder.encode(formateDate, "utf-8");

            //创建cookie
            Cookie cookie = new Cookie("lastTime", encode);
            //设置时间
            cookie.setMaxAge(60 * 60 * 24 * 7);
            //设置路径
            cookie.setPath("/");
            //响应cookie
            response.addCookie(cookie);

            response.getWriter().println("您是七天内第一次访问:" + formateDate);
            System.out.println("您是七天内一次访问,编码后的结果:" + encode);
        }
    }
}
