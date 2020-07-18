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
 *  @Date   : 2020/7/18 23:28
 */
@WebServlet("/downLoadCNImgServlet")
public class DownLoadCNImgServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        /**
         *  content-disposition  : 表示下载
         *      attachment 附件
         *      filename 文件名称
         *      通知浏览器以附件的形式下载流 并且设置文件名称问 xx.jpg
         */
        //response.setHeader("content-type","text/html;charset=utf-8"); 只控制响应体
        String filename= "图片.jpg";
        //----------------------------------------------------------
        //编写中文文件名称 处理
        //1.获得 浏览器的版本信息
        String agent = request.getHeader("user-agent");

        //2.调用工具类将文件名称编码
        filename = DownLoadUtils.getName(agent , filename );
        System.out.println(filename);

        //----------------------------------------------------------
        //特殊设置下载的头
        //在互联网上很少操作中文文件下载 , 中文有乱码 英文没有
        //为了防止图片名称的重复(时间毫秒值命名(时间戳) 随机的字符串-唯一 UUID 雪花算法 各种算法)
        //今天只是为了演示乱码的问题 以及解决方案
        response.setHeader("content-disposition" , "attachment;filename=" + filename);

        //1.获得一张图片 ServletContext 管理整个项目的资源
        //get 获得 Resource 资源 AsStream 转换成流  针对从web路径开始
        InputStream is = getServletContext().getResourceAsStream("/img/1.jpg");

        //2.写出去 需要输出流  空的
        ServletOutputStream os = response.getOutputStream();

        //3.流转换(将输入流转换成输出流)
        IOUtils.copy(is , os);
        is.close();
        os.close();
    }
}
