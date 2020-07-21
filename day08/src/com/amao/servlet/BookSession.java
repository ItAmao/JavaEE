package com.amao.servlet;

import com.amao.db.InitDB;
import com.amao.db.InitDB1;
import com.amao.domain.Book;
import com.amao.domain.Book1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/20 21:03
 */
@WebServlet("/bookSession")
public class BookSession extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.创建Session对象
        HttpSession session = request.getSession();

        //2.获取用户的书籍
        String bookId = request.getParameter("id");

        //3.通过id来获取数据的信息
        Book1 book = InitDB1.getBookById(bookId);
        //response.getWriter().println(book);

        //4.如果map集合是new出来的话,每次访问都会new一个map,就会把里面的值给覆盖掉,
        Map<String, Book1> map = (Map) session.getAttribute("shopCar");

        //5.如果没有购物车
        if (map == null) {
            map = new HashMap<>();
            //然后把book加入到map集合中,然后把count设置为1
            book.setCount(1);
            map.put(bookId, book);
        } else {
            //表示有购物车
            Book1 tempBook = map.get(bookId);
            //说明购物车里边有这本书
            if (tempBook != null) {
                tempBook.setCount(tempBook.getCount() + 1);
                map.put(bookId, tempBook);
            } else {
                book.setCount(1);
                map.put(bookId, book);
            }
        }
        //4.将map放入session中
        session.setAttribute("shopCar" , map);
    }
}
