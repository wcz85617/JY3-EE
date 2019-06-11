package com.neuedu.pojo;

public class User {
    private int id;
    private String userName;
    private String psw;

    public User(int id, String userName, String psw) {
        this.id = id;
        this.userName = userName;
        this.psw = psw;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPsw() {
        return psw;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}
