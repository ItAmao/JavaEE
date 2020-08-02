package com.itamao.java.dao.b_jdbc;

import org.junit.Test;

import java.sql.*;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/30 08:56
 */
public class JdbcDemo {
    /**
     * DriverManager:驱动管理类
     * registerDriver:注册驱动
     * new Driver():使用mysql的驱动
     *
     *
     */
    @Test
    public void testJdbc01() throws Exception {
        //1.注册驱动,相当于黑窗口中输入mysql,表示使用的哪个数据库
        Class.forName("com.mysql.jdbc.Driver");

        //2.获得连接,可以一直保持连接的状态,反复操作数据库
        //需要三个参数 第一个 主机 第二个 用户名 第三个 密码
        String url = "jdbc:mysql://localhost:3306/day04"; //连接的地址 jdbc:mysql://localhost:3306/day04
        String username = "root";//用户名
        String password = "root";//密码
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.获得语句执行者
        String sql = "insert into tbl_user values(null,'rose','1234','1000')";
        Statement statement = conn.createStatement();
        //4.执行语句://返回值:影响记录行数
        /*
            statement.executeUpdate()   增删改
            statement.executeQuery(SQL) 查询
         */
        int count = statement.executeUpdate(sql);
        //5.处理结果
        System.out.println(count);
        //6.释放资源
        statement.close();
        conn.close();
    }

}
