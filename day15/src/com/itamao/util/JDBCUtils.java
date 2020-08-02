package com.itamao.util;

import com.itamao.connection.ConnectionTest01;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/29 17:30
 *  操作数据库的工具类
 */
public class JDBCUtils {
    /**
     * 获取数据库的连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        //1.读取配置文件中的4个基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();

        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * 关闭连接
     */
    public static void closeResource(Connection conn, PreparedStatement ps) {
        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 关闭资源
     * @param conn
     * @param ps
     * @param rs
     */
    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
