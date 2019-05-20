package com.alibaba.dao;

import com.alibaba.pojo.User;
import com.alibaba.utils.DBUtils;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.sql.*;

public class UserDaoImpl implements UserDao {



    @Override
    public void regsiter(String user, String psw) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
           connection = DBUtils.getConnection();
           String sql = "INSERT INTO  User(userName,psw) VALUES(?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, psw);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closePstmt(preparedStatement);
            DBUtils.closeResource(connection);
        }
    }




    public User login(User user) {
        Connection connection = null;
        PreparedStatement pps = null;
        ResultSet rs = null;
        String id = null;

        try {
            connection = DBUtils.getConnection();
            String sql = "SELECT username,psw FROM user where userName = ? AND WEHERE psw = ?";
            pps = connection.prepareStatement(sql);
            pps.setString(1, user.getNameName());
            pps.setString(2, user.getPsw());
            rs = pps.executeQuery();
            if (null != rs){

                return  user;
            }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                 catch (Exception e) {
                    e.printStackTrace();
        }finally{
           DBUtils.closeResultSet(rs);
           DBUtils.closePstmt(pps);

        }
                     return null;
    }
}


