package com.alibaba.apache;

import com.alibaba.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DButilsDemo {


    public static void main(String[] args)  {

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///20190517", "root", "123456");
            QueryRunner queryRunner = new QueryRunner();
            String sql = "SELECT count(*) FROM user";
            long users = (long)queryRunner.query(conn, sql, new ScalarHandler<>());
            System.out.println(users);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
