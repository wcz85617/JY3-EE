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
        Connection conn = null;
        PreparedStatement pps = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT username,psw FROM user WHERE userName = ? AND psw = ?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, user.getName());
            pps.setString(2, user.getPsw());
            rs = pps.executeQuery();
            if (rs.next()) {

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResultSet(rs);
            DBUtils.closePstmt(pps);
            DBUtils.closeResource(conn);

        }
        return null;
    }

    public String pswGet(String userName) {
        Connection conn1 = null;
        PreparedStatement pps = null;
        ResultSet rs = null;
        String pwdd = "";
        conn1 = DBUtils.getConnection();
        String sql = "SELECT psw FROM user WHERE userName = ? ";
        try {
            pps = conn1.prepareStatement(sql);
            pps.setString(1, userName);
            rs = pps.executeQuery();
            if (rs.next()) {
                pwdd = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pwdd;
    }


    public void pswSte(String psw,String username) {
        Connection conn2 = null;
        PreparedStatement pps = null;
        ResultSet rs = null;
        conn2 = DBUtils.getConnection();
        String sql = "UPDATE user SET psw = ? WHERE userName = ? ";
        try {
            pps = conn2.prepareStatement(sql);
            pps.setString(1, psw);
            pps.setString(2, username);
            pps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}


