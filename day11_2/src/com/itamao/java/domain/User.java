package com.itamao.java.domain;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/25 18:14
 */
public class User {
    private String id;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String QQ;
    private String email;

    public User() {
    }

    public User(String id, String name, String gender, Integer age, String address, String QQ, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.QQ = QQ;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", QQ='" + QQ + '\'' +
                ", email='" + email + '\'' +
                '}';
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
        return address;
    }

    public String getQQ() {
        return QQ;
    }

    public String getEmail() {
        return email;
    }

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
        this.address = address;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
