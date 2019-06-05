package com.neuedu.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String userName;
    private String psw;

    public User(Integer id, String userName, String psw) {
        this.id = id;
        this.userName = userName;
        this.psw = psw;
    }
}
