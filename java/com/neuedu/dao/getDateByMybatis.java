package com.neuedu.dao;

import com.neuedu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;


public class getDateByMybatis {

    public static void main(String[] args) {

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
            SqlSession sqlSession = build.openSession();
            User getOneUser = sqlSession.selectOne("getOneUser", "10");
            System.out.println(getOneUser);
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
