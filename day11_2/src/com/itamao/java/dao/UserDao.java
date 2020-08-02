package com.itamao.java.dao;

import com.itamao.db.InitDao;
import com.itamao.java.domain.User;

import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/25 19:07
 */
public class UserDao {

    private InitDao initDao = new InitDao();

    public boolean register(User user) {
        return initDao.register(user);
    }


    public List<User> findAll() {
        return initDao.findAll();
    }

    public User findOne(String id) {
        return initDao.findOne(id);
    }
}
