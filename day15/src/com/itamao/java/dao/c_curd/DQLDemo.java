package com.itamao.java.dao.c_curd;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/30 09:47
 */
public class DQLDemo {
    @Test
    public void testSelect() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获得连接
        String url = "jdbc:mysql://localhost:3306/day04";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3.获取语句执行者对象
        Statement statement = conn.createStatement();
        //4.执行语句
        String sql = "select * from tbl_user";

        //5.处理结果
        /*
            ResultSet:结果集对象
            resultset
            提供了一个next()方法:表示下一个,返回值boolean
            作用:指针向下移动一位,同时返回true或者false,表示下一行是否有数据
         */
        ResultSet resultSet = statement.executeQuery(sql);
/*
        在结果集遍历之前,不允许操作数据
        String username1 = resultSet.getString("username");
        System.out.println(username1);
 */
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            System.out.println(id);
        }
        /*
        在结果集遍历之后,不允许操作数据
        String username1 = resultSet.getString("username");
        System.out.println(username1);
         */
        //6.释放资源
        resultSet.close();
        statement.close();
        conn.close();
    }
}
