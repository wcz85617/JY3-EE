package com.neuedu.dao;

import com.neuedu.pojo.Product;
import com.neundu.datasource.DruidDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class ProDaoImpl implements ProDao {

    private DruidDataSource dds;
    private QueryRunner qr;

    public ProDaoImpl(){
        this.dds = DruidDataSource.getDataSource();
         qr = new QueryRunner();

    }

    @Override
    public void addOnePro(Product pro) {
        Connection conn = dds.getConnection();
        String sql ="INSERT INTO product VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            qr.update(conn,sql,pro.getProId(),pro.getProName(),pro.getProPrice(),pro.getProImage(),pro.getProDes(),pro.getProStock(),pro.getProData(),pro.getProFactory(),pro.getProCategoryId());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
