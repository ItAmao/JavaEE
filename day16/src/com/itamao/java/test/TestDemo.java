package com.itamao.java.test;

import com.itamao.java.domain.User;
import com.itamao.java.service.UserService;
import org.junit.Test;

import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/31 17:30
 */
public class TestDemo {
    private UserService userService = new UserService();
    private User user = new User();

    /**
     * 添加
     */
    @Test
    public void testInsert() {
        //创建User对象
        user.setUsername("李四");
        user.setPassword("123");
        user.setMoney(5000);
        userService.insertUser(user);
    }

    /**
     * 删除
     */
    @Test
    public void testDelete() {
        userService.deleteUser(7);
    }

    /**
     * 修改
     */
    @Test
    public void testUpdate() {
        user.setId(8);
        user.setUsername("itamao");
        user.setPassword("1234");
        user.setMoney(3000);
        userService.updateUser(user);
    }

    /**
     * 查询所有
     */
    @Test
    public void testSelect() {
        List<User> userList = userService.selectUser();
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }

    /**
     * 使用@param注解
     * 通过id和用户名查询用户
     */
    @Test
    public void testFindUserByIdAndUsername() {
        Integer id = 1;
        String username = "amao";
        List<User> userList = userService.selectUserByIdAndUsername(id, username);
        System.out.println(userList);
    }

    /**
     * 使用concat模糊查询
     */
    @Test
    public void testSelectUserConcat() {
        List<User> userList = userService.selectUserConcat("李");
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }
}
