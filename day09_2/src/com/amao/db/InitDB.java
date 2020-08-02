package com.amao.db;

import com.amao.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/21 16:58
 */
public class InitDB {
    //存储数据的集合
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("1", "阿毛1", "男", 20, "湖南", "1234578", "12345@qq.com"));
        userList.add(new User("2", "阿毛2", "男", 21, "福建", "1234587", "12345@qq.com"));
        userList.add(new User("3", "阿毛3", "男", 22, "北京", "1234569", "12345@qq.com"));
        userList.add(new User("4", "阿毛4", "男", 23, "广东", "1234547", "12345@qq.com"));
        userList.add(new User("5", "阿毛5", "男", 24, "湖北", "1234537", "12345@qq.com"));
        userList.add(new User("6", "阿毛6", "男", 25, "天津", "1234526", "12345@qq.com"));
    }

    public static List<User> getList() {
        return userList;
    }

}
