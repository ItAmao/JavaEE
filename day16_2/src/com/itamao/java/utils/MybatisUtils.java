package com.itamao.java.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/31 17:03
 */
public class MybatisUtils {
    private static SqlSessionFactory factory = null;

    //创建sqlSession的工程只需要一个就行
    static {
        try {
            //加载流资源 一定要把sqlSessionConfig.xml放在src目录下
            InputStream is = Resources.getResourceAsStream("sqlSessionConfig.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //给外界提供创建sqlSession的方法
    public static SqlSession openSession() {
        SqlSession sqlSession = factory.openSession();
        return sqlSession;
    }

    //关闭资源
    public static void closeSqlSession(SqlSession sqlSession) {
        sqlSession.commit();
        sqlSession.close();
    }

}
