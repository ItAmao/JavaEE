package cn.itcast.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UploadServlet",urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 使用工具包来实现文件上传 commons-fileupload-1.2.1.jar
            // 使用api流程：
            //1 创建磁盘文件工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2 创建核心上传对象 (
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            //3 解析request
            List<FileItem> list = fileUpload.parseRequest(request);
            //4 遍历循环list
            for (FileItem fileItem : list) {
                //5 判断哪个是普通项 哪个是文件项
                if(fileItem.isFormField()){  //返回值是boolean  true：是普通项  false:是上传项
                     //普通项
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("utf-8");
                    System.out.println(name+":"+value);
                }else{
                    //上传项
                    String fileName = fileItem.getName();
                    fileName=UUID.randomUUID().toString().replace("-","")+fileName;
                    InputStream is = fileItem.getInputStream(); //文件内容
                    // 放入到服务器中
                    ServletContext servletContext = getServletContext();
                    String path = servletContext.getRealPath("/upload/");
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String date = format.format(new Date());
                    path=path+date+"/";
                    // 创建该文件夹upload
                    File file = new File(path);
                    if(!file.exists()){
                        file.mkdirs();
                    }
                    // 往该文件夹中写入内容
                    FileOutputStream os = new FileOutputStream(path + fileName);
                    // 读写
                    IOUtils.copy(is,os);
                    os.close();
                    is.close();
                }
            }
            response.getWriter().print("success!!!!");
        }catch (Exception e){
            e.printStackTrace();
        }




    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
