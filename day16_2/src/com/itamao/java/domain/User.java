package com.itamao.java.domain;

import lombok.Data;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/31 20:41
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer money;
}
