package com.neuedu.dao;

import com.neuedu.dao.UserDao;
import com.neuedu.pojo.User;
import com.neundu.datasource.DruidDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDameImpl implements UserDao {

    private QueryRunner qr = null ;
    private DruidDataSource dds = DruidDataSource.getDataSource();

    public UserDameImpl() {
        qr = new QueryRunner();

    }
    @Override
    public void regsiter(String user, String psw) {

    }

    //登录方法
    @Override
    public User login(User user) {
        Connection conn = null;
        PreparedStatement pps = null;
        ResultSet rs = null;

        try {
            conn = dds.getConnection();
            String sql = "SELECT userName,psw FROM user WHERE userName = ? AND psw = ?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, user.getUserName());
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
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String pswGet(String userName) {
        return null;
    }

    @Override
    public void pswSte(String psw, String username) {

    }

    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM user";
        List<User> users = null;
        Connection conn = dds.getConnection();
        try {
            users = qr.query(conn, sql, new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return users;
    }

    public void  setUser(User user)
    {
        String sql ="UPDATE user SET userName = ?,psw = ? WHERE id = ?";
        Connection conn1 = dds.getConnection();
        try {
            qr.update(conn1,sql,user.getUserName(),user.getPsw(),user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(conn1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


   //注册会员
    @Override
    public void addUser(User user) {
        String sql ="INSERT INTO user(userName,psw) VALUES(?,?)";
        Connection conn1 = dds.getConnection();
        try {
            qr.update(conn1,sql,user.getUserName(),user.getPsw());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
