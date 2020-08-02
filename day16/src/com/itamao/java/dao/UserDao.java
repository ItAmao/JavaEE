package com.itamao.java.dao;

import com.itamao.java.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/31 17:03
 */
public interface UserDao {

    /**
     * 添加
     * @return
     */
    void insertUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

    List<User> selectUser();

    List<User> selectUserByIdAndUsername(@Param("id") Integer id, @Param("username") String username);

    List<User> selectUserConcat(String username);
}
