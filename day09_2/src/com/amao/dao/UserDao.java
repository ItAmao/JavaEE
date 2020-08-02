package com.amao.dao;

import com.amao.db.InitDB;
import com.amao.domain.User;

import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/21 17:11
 */

/**
 * 数据库访问层
 * 调用initDB返回数据
 */
public class UserDao {
    public List<User> findAll() {
        return InitDB.getList();
    }
}
