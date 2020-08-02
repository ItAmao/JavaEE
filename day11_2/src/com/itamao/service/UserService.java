package com.itamao.service;

import com.itamao.java.dao.UserDao;
import com.itamao.java.domain.User;

import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/25 19:06
 */
public class UserService {

    private UserDao userDao = new UserDao();

    public boolean register(User user) {
        return userDao.register(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findOne(String id) {
        return userDao.findOne(id);
    }
}
