package com.itamao.java.dao;

import com.itamao.java.domain.QueryVo;
import com.itamao.java.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/8/2 17:17
 */
public interface UserDao {

    List<User> findAll();

    void saveUser(User user);

    List<User> selectIf(User user);

    List<User> selectChoose(User user);

    void updateUser(User user);

    List<User> selectForeachArray(int[] arr);

    List<User> selectForeachCollection(ArrayList<Integer> arr);

    List<User> selectByQueryVo(QueryVo queryVo);
}
