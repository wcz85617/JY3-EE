package com.neuedu.dao;

import com.neuedu.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    void  setUser(User user);
    void addUser(User user);
}
