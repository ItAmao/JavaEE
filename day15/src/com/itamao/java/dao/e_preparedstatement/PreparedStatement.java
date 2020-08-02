package com.itamao.java.dao.e_preparedstatement;

import com.itamao.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/30 14:50
 */
public class PreparedStatement {
    @Test
    public void testInsert() throws Exception {
        //1.获得连接
        Connection conn = JDBCUtils.getConnection();
        //2.获得预处理对象,将sql语句发送给数据库进行编译
        String sql = "insert into tbl_user values(null,?,?,?)";
        java.sql.PreparedStatement ps = conn.prepareStatement(sql);
        //3.赋值数据
        ps.setString(1, "amao");
        ps.setString(2, "123");
        ps.setInt(3, 2000);
        //4.发送数据到数据库,进行执行
        int count = ps.executeUpdate();
        //5.处理结果
        System.out.println(count);
        //6.释放资源
        JDBCUtils.closeResource(conn, ps);
    }

    @Test
    public void testSelect() throws Exception {
        //1.获得连接
        Connection conn = JDBCUtils.getConnection();
        //2.获得预编译对象
        String sql = "select * from tbl_user";
        //3.赋值数据
        java.sql.PreparedStatement ps = conn.prepareStatement(sql);
        //4.执行查询

        //5.处理结果
        //6.释放资源
    }
}
