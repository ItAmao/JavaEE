package com.itamao.service;

import com.itamao.java.dao.UserDao;
import com.itamao.java.domain.User;

import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/22 10:13
 */
public class UserService {
    private static UserDao userDao = new UserDao();

    public void add(User user) {
        //简单项目,不做任何业务逻辑处理.直接调用
        userDao.add(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(String uid) {
        return userDao.findById(uid);
    }

    public void deleteById(String uid) {
        userDao.deleteById(uid);
    }
}
