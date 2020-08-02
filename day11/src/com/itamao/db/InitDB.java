package com.itamao.db;

import com.itamao.java.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/23 20:35
 */
public class InitDB {
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("1", "itamao", "男", 23));
        userList.add(new User("2", "itkaige", "男", 23));
        userList.add(new User("3", "itjingge", "男", 23));
        userList.add(new User("4", "itxinke", "男", 23));
        userList.add(new User("5", "itlaozhang", "女", 21));
    }


    //提供一个方法
    public List<User> list() {
        return userList;
    }
}
