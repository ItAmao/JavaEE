package com.amao.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/19 20:23
 */
public class User {
    private String name;
    private int age;
    private Date birthday;

    public User(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //逻辑视图
    public String getBirthday() {
        if (birthday != null) {
            //1.格式化日期对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //2.返回字符串即可
            return sdf.format(birthday);

        } else {
            return "";
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
