package com.neuedu.dao;

import com.neuedu.pojo.User;

public interface UserDemo {

      //根据ID查询部门信息
    public User getOneById(String id);

    public  Integer addUserAndgetId(User user);

}
