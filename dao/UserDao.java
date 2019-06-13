package com.neuedu.dao;

import com.neuedu.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    void  setUser(User user);
    User denglu(User user) throws SQLException;

}

