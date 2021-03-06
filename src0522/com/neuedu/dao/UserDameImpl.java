package com.neuedu.dao;

import com.neuedu.dao.UserDao;
import com.neuedu.pojo.User;
import com.neundu.datasource.DruidDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDameImpl implements UserDao {

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
}
