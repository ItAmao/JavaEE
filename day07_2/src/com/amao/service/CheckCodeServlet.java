package com.amao.service;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/16 20:05
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 40;

        //1.创建一个对象,能在内存中图片(验证码的图片对象)
        //第一个参数表示宽度
        //第二个参数表示长度
        //第三个参数表示图片的类型
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1 填充背景色 Graphics:图形
        Graphics g = image.getGraphics();//画笔对象
        //填空之前设置画笔背景色
        g.setColor(Color.orange);//设置画笔的颜色
        g.fillRect(0, 0, width, height);

        //2.2 画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);

        //定义一个随机码
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random random = new Random();

        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);//随机字符
            //2.3.写验证码
            g.drawString(ch + "", width / 5 * i, height / 2);
        }
        //2.4画干扰线
        g.setColor(Color.blue);

        //随机生成坐标点
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1, x2, y1, y2);
        }
        //3.将图片输出到页面展示
        //第一个参数是图片对象
        //第二个参数是图片的后缀名
        //第三个参数是输出流
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
