package com.itamao.preparedstatement.crud;

import com.itamao.connection.ConnectionTest01;
import com.itamao.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/29 15:58
 */
public class PreparedStatementUpdateTest {

    //通用的增删改操作
    public void update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //sql中的占位符的个数,必须和args的长度一致

            //获取数据库的连接
            conn = JDBCUtils.getConnection();
            //预编译sql语句,返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //执行操作
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.closeResource(conn, ps);
        }
    }

    @Test
    public void testCommonUpdate() {
        String sql = "delete from customers where id=?";

        update(sql, 19);
    }


    /**
     * 向customer表中添加一条记录
     */
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;


        try {
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
            conn = DriverManager.getConnection(url, user, password);

            //4.获取preparedStatement
            String sql = "insert into customers(name,email,birth)values(?,?,?)"; //?:占位符
            ps = conn.prepareStatement(sql);

            //5.填空占位符
            ps.setString(1, "阿毛");
            ps.setString(2, "amao@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("1000-01-01");
            ps.setDate(3, new java.sql.Date(date.getTime()));
            //6.执行sql
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.资源关闭
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
    }

    /**
     * 修改表
     */
    @Test
    public void testUpdate() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句,返回PreparedStatement的实例
            String sql = "update customers set name= ? where id= ?";
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            ps.setObject(1, "莫扎特");
            ps.setObject(2, 18);
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }


}
