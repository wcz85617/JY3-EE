package com.alibaba.dao;

import com.alibaba.pojo.User;

public interface UserDao {

    void  regsiter(String user,String psw);

    User login(User user);
}
