package com.itamao.java.dao.c_curd;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/30 09:35
 */
public class DMLDemo {
    @Test
    public void testSave() {
    }


    @Test
    public void testUpdate() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获得连接
        String url = "jdbc:mysql://localhost:3306/day04";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3.获取语句执行者对象
        Statement statement = conn.createStatement();
        String sql = "update tbl_user set username='amao' where id=1";
        //4.执行语句
        int count = statement.executeUpdate(sql);
        //5.处理结果
        System.out.println(count);
        //6.关闭
        statement.close();
        conn.close();
    }

    @Test
    public void testDelete() {

    }
}
