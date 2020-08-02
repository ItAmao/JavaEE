package com.itamao.java.domain;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/23 19:51
 */
public class User {
    private String uid;
    private String name;
    private String gender;
    private int age;

    public User(String uid, String name, String gender, int age) {
        this.uid = uid;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public User() {
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "个人信息{" +
                "编号='" + uid + '\'' +
                ", 姓名='" + name + '\'' +
                ", 性别='" + gender + '\'' +
                ", 年龄1=" + age +
                '}';
    }
}
