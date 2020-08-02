package com.itamao.db;

import com.itamao.java.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/25 19:09
 */
public class InitDao {

    private static List<User> list = new ArrayList<>();

    /*
    1,刘德华,男,28,香港,123456,123456@qq.com
    2,梁朝伟,男,38,香港,223456,223456@qq.com
    3,冯小刚,男,48,北京,66779921,fxgg@163.com
    4,郭德纲,男,48,北京,1233212,guodegang@163.com
     */
    static {
        list.add(new User("1", "刘德华", "男", 28, "香港", "123456", "123456@qq.com"));
        list.add(new User("2", "梁朝伟", "男", 38, "香港", "223456", "223456@qq.com"));
        list.add(new User("3", "冯小刚", "男", 48, "北京", "66779921", "fxgg@163.com"));
        list.add(new User("4", "郭德纲", "男", 48, "北京", "1233212", "guodegang@163.com"));
    }


    public boolean register(User user) {
        System.out.println(user);
        if (list.isEmpty()) {
            user.setId("1");
            list.add(user);
        } else {
            String sid = list.get(list.size() - 1).getId();
            Integer iid = Integer.parseInt(sid);
            iid += 1;
            sid = iid.toString();
            user.setId(sid);
            list.add(user);
        }
        for (User user1 : list) {
            System.out.println(user1);
        }
        return true;
    }

    public List<User> findAll() {
        return list;
    }

    public User findOne(String id) {
        for (User user : list) {
            if (id.equals(user.getId())) {
                return user;
            }
        }
        return null;
    }
}
