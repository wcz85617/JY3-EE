package com.neuedu.dao;

import com.neuedu.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    void  setUser(User user);
    //根据开始索引和条数查询用户数据
    List<User> getUsers(int startIndex,int pageSize);

    //查询总的记录数
    Integer getAllRecords();

}
