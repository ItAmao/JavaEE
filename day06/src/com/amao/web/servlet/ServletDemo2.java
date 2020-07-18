package com.amao.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet的方法
 *
 *  @Author : ItAmao
 *  @Date   : 2020/7/15 18:50
 */
public class ServletDemo2 implements Servlet {
    /**
     * 初始化方法:在servlet在创建时执行
     * 只会执行一次
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init........");
    }

    /**
     *  获取ServletConfig对象的
     *  ServletConfig:Servlet的配置对象
     *  ;;
     *
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法,每一次servlet被访问时执行, 执行多次
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service........");
    }

    /**
     *  获取servlet的一些信息的,版本,作者...
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法,在servlet被杀死时执行
     * 在服务器正常关闭时执行
     */
    @Override
    public void destroy() {
        System.out.println("destroy........");
    }
}
