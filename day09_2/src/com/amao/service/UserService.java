package com.amao.service;

import com.amao.dao.UserDao;
import com.amao.domain.User;

import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/21 17:08
 */

/**
 * 业务逻辑层
 */
public class UserService {

    public List<User> findAll() {
        //创建dao对象
        UserDao userDao = new UserDao();
        //调用方法
        List<User> userList = userDao.findAll();

        return userList;
    }
}
