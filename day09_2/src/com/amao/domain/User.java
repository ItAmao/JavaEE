package com.amao.domain;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/21 16:58
 */
public class User {
    private String id;
    private String name;
    private String gender;
    private Integer age;
    private String Address;
    private String qq;
    private String email;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return Address;
    }

    public String getQq() {
        return qq;
    }

    public String getEmail() {
        return email;
    }

    public User() {
    }

    public User(String id, String name, String gender, Integer age, String address, String qq, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        Address = address;
        this.qq = qq;
        this.email = email;
    }
}
