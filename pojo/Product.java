package com.neuedu.pojo;

import java.sql.Date;

public class Product {

    private String proId;
    private String proName;
    private double proPrice;
    private String proImage;
    private String proDes;
    private Integer proStock;
    private Date proData;
    private String proFactory;
    private String proCategoryId;

    public Product() {
    }

    public Product(String proId, String proName, double proPrice, String proImage, String proDes, Integer proStock, Date proData, String proFactory, String proCategoryId) {
        this.proId = proId;
        this.proName = proName;
        this.proPrice = proPrice;
        this.proImage = proImage;
        this.proDes = proDes;
        this.proStock = proStock;
        this.proData = proData;
        this.proFactory = proFactory;
        this.proCategoryId = proCategoryId;
    }

    public String getProId() {
        return proId;
    }

    public String getProName() {
        return proName;
    }

    public double getProPrice() {
        return proPrice;
    }

    public String getProImage() {
        return proImage;
    }

    public String getProDes() {
        return proDes;
    }

    public Integer getProStock() {
        return proStock;
    }

    public Date getProData() {
        return proData;
    }

    public String getProFactory() {
        return proFactory;
    }

    public String getProCategoryId() {
        return proCategoryId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public void setProPrice(double proPrice) {
        this.proPrice = proPrice;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public void setProDes(String proDes) {
        this.proDes = proDes;
    }

    public void setProStock(Integer proStock) {
        this.proStock = proStock;
    }

    public void setProData(Date proData) {
        this.proData = proData;
    }

    public void setProFactory(String proFactory) {
        this.proFactory = proFactory;
    }

    public void setProCategoryId(String proCategoryId) {
        this.proCategoryId = proCategoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "proId='" + proId + '\'' +
                ", proName='" + proName + '\'' +
                ", proPrice=" + proPrice +
                ", proImage='" + proImage + '\'' +
                ", proDes='" + proDes + '\'' +
                ", proStock=" + proStock +
                ", proData='" + proData + '\'' +
                ", proFactory='" + proFactory + '\'' +
                ", proCategoryId='" + proCategoryId + '\'' +
                '}';
    }
}
