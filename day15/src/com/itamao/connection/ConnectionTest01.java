package com.itamao.connection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/29 14:19
 */
public class ConnectionTest01 {

    //方式一:
    @Test
    public void testConnection1() throws SQLException {
        //获取Driver的实现类对象
        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/test";
//        jdbc:mysql 表示协议
//        localhost:ip地址
//        3306:数据库端口号
//        test:数据库
        Properties info = new Properties();
        //将用户名和密码封装到Properties中
        info.setProperty("user", "root");
        info.setProperty("password", "root");
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    //方式二:在如下的程序中不出现第三方的api 使得程序具有更好的可移植性
    @Test
    public void testConnection2() throws Exception {
        //1.获取Driver实现类对象,反射
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        //2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";

        //3.提供连接需要的用户名和密码
        Properties info = new Properties();
        //将用户名和密码封装到Properties中
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        //4,获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    //方式三:使用DriverManager替换Driver
    @Test
    public void testConnection3() throws Exception {

        //1.获取Driver的实现类对象
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        //2.提供另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";
        //1.注册驱动
        DriverManager.registerDriver(driver);
        //2.获取连接
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);
    }

    //方式四:相较于方式三,可以省略注册驱动,因为Driver源码中,提供了静态代码块注册
    @Test
    public void testConnection4() throws Exception {
        //1.提供另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";

        //2.加载Driver
        Class.forName("com.mysql.jdbc.Driver");
//        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver = (Driver) clazz.newInstance();
//        //注册驱动
//        DriverManager.registerDriver(driver);
        //3.获取连接
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);
    }

    //最终版 将数据库连接需要的4个基本声明在配置文件中,通过读取配置文件的方式,获取连接
    @Test
    public void testConnection5() throws Exception {
        //1.读取配置文件中的4个基本信息
        InputStream is = ConnectionTest01.class.getClassLoader().getResourceAsStream("jdbc.properties");

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
        System.out.println(conn);
    }
}
