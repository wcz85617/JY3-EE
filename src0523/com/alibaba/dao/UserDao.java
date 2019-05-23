package com.alibaba.dao;

import com.alibaba.pojo.User;

public interface UserDao {

    void  regsiter(String user,String psw);

    User login(User user);

    String pswGet(String userName);
    public void pswSte(String psw,String username);
}
