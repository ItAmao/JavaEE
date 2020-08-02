package com.itamao.java.domain;

public class Account {
    private Integer id;//id       int(11)
    private Integer money;//money    int(11)
    private String address;//address  varchar(32)
    private String aname;//aname    varchar(32)
    private Integer uid;//uid      int(11)

    //账户对应 一个用户
    private User user; //存放一个对象的引用 对象中含有 user所有属性

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                ", address='" + address + '\'' +
                ", aname='" + aname + '\'' +
                ", uid=" + uid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
