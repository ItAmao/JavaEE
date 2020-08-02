package com.itamao.java.dao;


import com.itamao.db.InitDB;
import com.itamao.java.domain.User;
import org.junit.Test;

import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/22 10:18
 */
public class UserDao {
    private static InitDB db = new InitDB();

    public void add(User user) {
        List<User> list = db.list();
        list.add(user);
    }

    public List<User> findAll() {
        List<User> list = db.list();
        return list;
    }

    public User findById(String uid) {
        List<User> list = db.list();
        User user1 = null;
        for (User user : list) {
            if (uid.equals(user.getUid())) {
                user1 = user;
            }
        }
        return user1;
    }

    public void deleteById(String uid) {
        User user = findById(uid);
        List<User> list = db.list();
        list.remove(user);
        for (User user1 : list) {
            System.out.println(user1);
        }
    }

    @Test
    public void test() {
        String uid = "1";
        deleteById(uid);
    }
}
