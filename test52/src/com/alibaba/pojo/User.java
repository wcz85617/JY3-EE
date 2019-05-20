package com.alibaba.pojo;

public class User {

    private  String  nameName;
    private  String  psw;

    public User(String nameName, String psw) {
        this.nameName = nameName;
        this.psw = psw;
    }
    public User()
    {

    }

    public void setNameName(String nameName) {
        this.nameName = nameName;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getNameName() {
        return nameName;
    }

    public String getPsw() {
        return psw;
    }

    @Override
    public String toString() {
        return "User{" +
                "nameName='" + nameName + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}


