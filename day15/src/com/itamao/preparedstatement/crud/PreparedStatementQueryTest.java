package com.itamao.preparedstatement.crud;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/29 21:30
 */

import com.itamao.util.JDBCUtils;
import com.itamao.util.domain.Customer;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用PreparedStatement来实现针对于不同表的通用的查询操作
 */
public class PreparedStatementQueryTest {
    @Test
    public void testGetForList() {
        String sql = "select id,name,birth,email from customers where id<?";
        List<Customer> list = getForList(Customer.class, sql, 12);

        list.forEach(System.out::println);
    }

    public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            //获取结果集的元数据,:ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMethodData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            //创建集合对象
            ArrayList<T> list = new ArrayList<T>();
            while (rs.next()) {
//                //创建对象
//                Customer cust = new Customer();
                T t = clazz.newInstance();
                //处理结果集一行数据中的每一列,给t对象指定的属性赋值
                //处理结果集一行数据中的每一列
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columValue = rs.getObject(i + 1);
                    //获取
                    //通过反射,获取每个列的列名
                    String columnName = rsmd.getColumnName(i + 1);
                    //给cust对象指定的某个属性赋值为columValue,通过反射
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }


    @Test
    public void testGetInstance() {
        String sql = "select id,name,email from customers where id=?";
        Customer customer = getInstance(Customer.class, sql, 1);
        System.out.println(customer);
    }

    /**
     * 针对不同的表的通用的查询操作,返回表中一条记录
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T getInstance(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            //获取结果集的元数据,:ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMethodData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
//                //创建对象
//                Customer cust = new Customer();
                T t = clazz.newInstance();
                //处理结果集一行数据中的每一列
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columValue = rs.getObject(i + 1);
                    //获取
                    //通过反射,获取每个列的列名
                    String columnName = rsmd.getColumnName(i + 1);
                    //给cust对象指定的某个属性赋值为columValue,通过反射
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }


}
