package com.amao.web.response.d_download;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/18 23:21
 */
@WebServlet("/downLoadImgServlet")
public class DownLoadImgServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("1");
        //1.特殊设置下载的头
        //第一个参数:表示下载
        //第二个参数: attachment表示附件 filename表示文件名字 通知浏览器以附件的形式下载流 并且设置文件名称问 xx.jpg
        response.setHeader("content-disposition", "attachment;filename=xx.jpg");

        //2.通过输入流去获取一张图片
        InputStream is = getServletContext().getResourceAsStream("img/1.jpg");

        //3.展示到页面
        ServletOutputStream sos = response.getOutputStream();

        //4.流转换
        IOUtils.copy(is, sos);
        is.close();
        sos.close();

    }
}
