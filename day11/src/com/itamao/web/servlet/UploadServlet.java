package com.itamao.web.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/24 15:23
 */
@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.
        String username = request.getParameter("username");
        String nickname = request.getParameter("nickname");
        String file = request.getParameter("MyFile");

        //1.创建磁盘文件项对象:本质是IO 最终的目的 其实就是为了操作文件的io
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2.创建servlet文件上传对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> list = null;
        //3.解析request对象 FileItem文件项
        try {
            //4.获得list集合数据(普通表单数据,文件上传数据)
            list = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        //5.遍历
        for (FileItem fileItem : list) {
            boolean flag = fileItem.isFormField();
            if (flag) {
//                String name = fileItem.getName();
//                String fieldName = fileItem.getFieldName(); //input的name属性
//                String value = fileItem.getString("utf-8"); //设置编码 获取值
            } else {
                //文件上传
                String name = fileItem.getName();//表示文件名称
                String fieldName = fileItem.getFieldName();//input组件的name属性
                //String value = fileItem.getString("utf-8");
                InputStream is = fileItem.getInputStream();

                //获得web下的资源路径
                String realPath = getServletContext().getRealPath("/img");

                FileOutputStream os = new FileOutputStream(realPath + "/" + name);

                IOUtils.copy(is, os);
                is.close();
                os.close();


            }
        }
    }
}
