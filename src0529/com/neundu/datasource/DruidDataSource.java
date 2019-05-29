package com.neundu.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DruidDataSource {
  //创建私有的配置文件
    private static Properties prop = new Properties();

    //连接池实现单例
    private  static DruidDataSource ds = null ;

    private DruidDataSource()
    {
    }

    public  static  DruidDataSource getDataSource(){
        if(null == ds){
           ds = new DruidDataSource();
        }
        return ds;
    }

    //取得连接
    public Connection getConnection()
    {
        try {
            prop.load(DruidDataSource.class.getResourceAsStream("/masql.properties"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            Connection connection = dataSource.getConnection();
            return  connection;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;

    }

    public static void main(String[] args) {
        DruidDataSource dataSource = DruidDataSource.getDataSource();
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }









}
