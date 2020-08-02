package com.itamao.java.service;

import com.itamao.java.dao.UserDao;
import com.itamao.java.domain.User;
import com.itamao.java.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/31 20:46
 */
public class UserService {

    private static SqlSession sqlSession = null;
    private static UserDao userDao = null;

    static {
        sqlSession = MybatisUtils.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
        MybatisUtils.closeSqlSession(sqlSession);
    }

    public boolean loginUser(String username, String password) {
        //service层做逻辑判断,获取到用户传来的信息,与数据库进行比对
        List<User> userList = userDao.selectAllUser();
        System.out.println("1");
        for (User user : userList) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
