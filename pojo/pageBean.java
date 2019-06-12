package com.neuedu.pojo;

import java.util.List;

public class pageBean {
    //当前页数
    private int pageNum;
    //每页显示的条数
    private int pageSize;
    //总记录数
    private int allRecords;
    //总页数
    private  int allPage;
    //sql开始的索引
    private int startIndex;
    //首页
    private  int  startPage;
    //结束的页数
    private  int endPage;
    //查出来的信息
    private List<User> users;

    public pageBean() {
    }

    public pageBean(int pageNum, int pageSize, int allRecords) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.allRecords = allRecords;
        if (allRecords/pageSize==0)
        {
            this.allPage=allRecords/pageSize;
        }else {
            this.allPage=allRecords/pageSize+1;
        }
        this.startIndex = (pageNum-1)*pageSize;
        this.startPage = 1;
        this.endPage = 5;
        if (allPage <= 5){
            endPage = allPage;
        }else {

           this.startPage = this.pageNum - 2;
           this.endPage = this.pageNum +2;
           if (startPage<=0){
               this.startPage = 1;
               this.endPage = 5;
           }
           if(endPage>allPage){
               this.startPage = this.allPage-4;
               this.endPage = this.allPage;
           }
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getAllRecords() {
        return allRecords;
    }

    public void setAllRecords(int allRecords) {
        this.allRecords = allRecords;
    }

    public int getAllPage() {
        return allPage;
    }

    public void setAllPage(int allPage) {
        this.allPage = allPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "pageBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", allRecords=" + allRecords +
                ", allPage=" + allPage +
                ", startIndex=" + startIndex +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", emps=" + users +
                '}';
    }
}
