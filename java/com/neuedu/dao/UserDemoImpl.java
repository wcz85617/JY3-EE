package com.neuedu.dao;

import com.neuedu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.sql.Connection;

public class UserDemoImpl implements UserDemo {

    private SqlSessionFactory ssf;

    public UserDemoImpl() {

        try {
            ssf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getOneById(String id) {
        SqlSession sqlSession = ssf.openSession();
        User getOneUser = sqlSession.selectOne("getOneUser", id);
        return getOneUser;
    }

    @Override
    public Integer addUserAndgetId(User user) {
        SqlSession sqlSession = ssf.openSession();
        int adduser = sqlSession.insert("addUser", user);
        //int i = sqlSession.insert("addUser", user);
        sqlSession.commit();
        return adduser;
    }
}
