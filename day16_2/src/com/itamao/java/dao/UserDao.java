package com.itamao.java.dao;

import com.itamao.java.domain.User;

import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/31 20:30
 */
public interface UserDao {

    void insertUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

    List<User> selectAllUser();



}
