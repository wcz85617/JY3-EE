package com.neuedu.text;


import com.neuedu.dao.UserDemo;
import com.neuedu.dao.UserDemoImpl;
import com.neuedu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class Test01 {

    private UserDemo ud;
    @Before
    public  void before(){
     ud = new UserDemoImpl();
    }

    @Test
    public void  test(){

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
            SqlSession sqlSession = build.openSession();
            //模糊查询
           // User getOneUser = sqlSession.selectOne("getUserByName", "%25%");
//            List<User> getUserByName = sqlSession.selectList("getUserByName", "%2%");
//            System.out.println(getUserByName);

            //查询多个
//            List<User> allUser = sqlSession.selectList("allUser");
//            System.out.println(allUser);

            //添加一个
//            User luce = new User("18", "luce", "112233");
//            int insert = sqlSession.insert("addOneUser", luce);
//            System.out.println(insert);

            //修改
//            User user = new User("8", "张飞", "888888");
//            int setUser = sqlSession.update("setUser", user);
//            System.out.println(setUser);

            //删除
//            int deluser = sqlSession.update("deluser", "13");
//            System.out.println(deluser);

             //调用DAO层查询
//            User oneById = ud.getOneById("11");
//            System.out.println(oneById);

//           增加用户同时返回id号码
            User user = new User(null, "周发", "aaddvv");
            int i = ud.addUserAndgetId(user);
            System.out.println(user.getId());

            //sqlSession.commit();
            //sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @After
    public  void  after(){
    }
}

