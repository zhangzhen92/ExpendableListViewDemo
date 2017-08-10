package com.example.zz.myapplication.bean;

/**
 * 类描述：子类实体
 * 创建人：zz
 * 创建时间： 2017/8/10 14:48
 */


public class ChildBean {
    private String userName;
    private String passWord;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ChildBean(String userName, int status, String passWord) {
        this.userName = userName;
        this.status = status;
        this.passWord = passWord;
    }

    public ChildBean() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
