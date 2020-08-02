package com.itamao.java.test;

import com.google.common.collect.Lists;
import com.itamao.java.dao.AccountDao;
import com.itamao.java.dao.UserDao;
import com.itamao.java.domain.Account;
import com.itamao.java.domain.QueryVo;
import com.itamao.java.domain.User;
import com.itamao.java.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/8/2 17:19
 */
public class TestDemo {
    private SqlSession sqlSession = null;
    private UserDao userDao = null;
    private User user = null;
    private Account account = null;
    private AccountDao accountDao = null;

    @Before
    public void before() {
        sqlSession = MybatisUtils.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
        user = new User();
        accountDao = sqlSession.getMapper(AccountDao.class);
        account = new Account();
    }

    @Test
    public void insert() {
        user.setUsername("jack");
        user.setGender("男");
        user.setTelephone("1234578");
        user.setPassword("1234");
        user.setEmail("1234@qq.com");
        System.out.println("添加前的数据:" + user);
        userDao.saveUser(user);
        System.out.println("添加后的数据:" + user);
    }

    @Test
    public void selectIf() {
        user.setUsername("张三");
        user.setGender("男");
        List<User> userList = userDao.selectIf(user);
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }

    @Test
    public void selectChoose() {
//        user.setUsername("张三");
//        user.setGender("男");
        List<User> userList = userDao.selectChoose(user);
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }

    @Test
    public void updateSet() {
        //oldUser  数据库数据
        User user = new User();
        user.setId(10);
        user.setUsername("jerry");
        user.setGender("女");
        user.setTelephone("2222");
        user.setPassword("222");
        user.setEmail("2222@qq.com");
        userDao.updateUser(user);
    }

    @Test
    public void selectForeachArray() {
        int[] arr = {1, 3, 5, 7, 9};
        List<User> userList = userDao.selectForeachArray(arr);
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }

    @Test
    public void selectForeachCollection() {
        ArrayList<Integer> arr = Lists.newArrayList();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(7);
        List<User> userList = userDao.selectForeachCollection(arr);
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }

    @Test
    public void selectByQueryVo() {
        Integer[] arr1 = {1, 3, 5, 7, 9};
        ArrayList<Integer> arr2 = Lists.newArrayList();
        arr2.add(1);
        arr2.add(3);
        arr2.add(5);
        arr2.add(7);
        QueryVo queryVo = new QueryVo();
        queryVo.setIdsArray(arr1);
        queryVo.setIdsList(arr2);
        List<User> userList = userDao.selectByQueryVo(queryVo);
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }

    @Test
    public void testOneToOne() {
        //表示一个账户对应一个用户
        List<Account> accounts = accountDao.findAll();
        for (Account account1 : accounts) {
            System.out.println(account1 + "@@" + account1.getUser());
        }
    }

    @Test
    public void testOneToMany() {
        //表示一个用户对应多个账户
        List<User> userList = userDao.findAll();
        for (User user1 : userList) {
            System.out.println(user1 + "@@" + user1.getAccounts());
        }
    }


    @After
    public void after() {
        MybatisUtils.closeSqlSession(sqlSession);
    }
}
