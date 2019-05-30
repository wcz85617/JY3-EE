package com.alibaba.pojo;

public class User {

    private  String  name;
    private  String  psw;

    public User() {
    }

    public User(String name, String psw) {
        this.name = name;
        this.psw = psw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public String getPsw() {
        return psw;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}


