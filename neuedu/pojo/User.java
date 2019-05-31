package com.neuedu.pojo;

public class User {
    private String userName;
    private String psw;
    public User() {
    }

    public User( String userName, String psw) {
        this.userName = userName;
        this.psw = psw;
    }



    public String getUserName() {
        return userName;
    }

    public String getPsw() {
        return psw;
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
                "userName='" + userName + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}
