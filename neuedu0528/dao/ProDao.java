package com.neuedu.dao;

import com.neuedu.pojo.Product;

public interface ProDao {

    void addOnePro(Product pro);
    void delOnePro(String proName);
    void  setPro(Product pro);



}
