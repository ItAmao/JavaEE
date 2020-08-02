package com.itamao.java.service;

import com.itamao.java.dao.UserDao;
import com.itamao.java.domain.User;
import com.itamao.java.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/31 17:03
 */
public class UserService {
    private static SqlSession sqlSession = MybatisUtils.openSession();
    private static UserDao userDao = sqlSession.getMapper(UserDao.class);

    public void insertUser(User user) {
        userDao.insertUser(user);
        MybatisUtils.closeSqlSession(sqlSession);
    }

    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
        MybatisUtils.closeSqlSession(sqlSession);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
        MybatisUtils.closeSqlSession(sqlSession);
    }

    public List<User> selectUser() {
        List<User> userList = userDao.selectUser();
        return userList;
    }

    public List<User> selectUserByIdAndUsername(Integer id, String username) {
        return userDao.selectUserByIdAndUsername(id, username);
    }

    public List<User> selectUserConcat(String username) {
        return userDao.selectUserConcat(username);
    }
}
