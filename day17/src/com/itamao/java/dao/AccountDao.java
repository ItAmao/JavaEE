package com.itamao.java.dao;


import com.itamao.java.domain.Account;

import java.util.List;

public interface AccountDao {
    //查询所有的账户信息
    List<Account> findAll();
}
