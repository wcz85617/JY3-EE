package com.neuedu.dao;

import com.neuedu.dao.UserDao;
import com.neuedu.pojo.User;
import com.neundu.datasource.DruidDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.net.UnknownServiceException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class  UserDameImpl implements UserDao {


    private QueryRunner qr = null ;
    private DruidDataSource dds = DruidDataSource.getDataSource();

    public UserDameImpl() {
        qr = new QueryRunner();

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

    @Override
    public List<User> getUsers(int startIndex, int pageSize) {
        Connection connection = dds.getConnection();
        String sql = "SELECT * FROM user LIMIT ?,?";
        try {
            List<User> users = qr.query(connection, sql, new BeanListHandler<>(User.class), startIndex, pageSize);
            return  users;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Integer getAllRecords() {
        Connection connection = dds.getConnection();
        String sql = "SELECT count(*) FROM user ";

        try {
            Long count = qr.query(connection, sql, new ScalarHandler<>());
            return Integer.parseInt(count.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

////    public static void main(String[] args) {
////        UserDameImpl userDame = new UserDameImpl();
////        List<User> allUser = userDame.getAllUser();
////        System.out.println(allUser);
//
//    }
}
