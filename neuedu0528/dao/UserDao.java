package com.neuedu.dao;

import com.neuedu.pojo.User;

import java.util.List;

public interface UserDao {
    void  regsiter(String user,String psw);

    User login(User user);

    String pswGet(String userName);
    public void pswSte(String psw,String username);
    List<User> getAllUser();
    void  setUser(User user);
    void addUser(User user);
}
