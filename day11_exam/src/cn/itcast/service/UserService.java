package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

import java.util.List;

// 用户相关的业务逻辑
public class UserService {

    private UserDao userDao=new UserDao();

    //用户的查询
    public List<User> find() {
        // 调用dao拿用户数据
        return userDao.find();
    }

    // 用户的添加
    public void add(User user) {
        // 带着参数调用dao
        userDao.add(user);
    }

    // 用户的删除
    public void delete(String id) {
        userDao.delete(id);
    }

    // 修改上集：数据回显
    public User findById(String id) {
        return userDao.findById(id);
    }

    // 修改下集：用户数据的修改
    public void update(User user) {
        userDao.update(user);
    }
}
