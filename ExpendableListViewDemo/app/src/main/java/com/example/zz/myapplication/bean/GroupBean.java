package com.example.zz.myapplication.bean;

import java.util.List;

/**
 * 类描述：父类实体
 * 创建人：zz
 * 创建时间： 2017/8/10 14:48
 */


public class GroupBean {
    private String name;
    private List<ChildBean> childs;

    public GroupBean() {
    }

    public GroupBean(List<ChildBean> childs, String name) {
        this.childs = childs;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChildBean> getChilds() {
        return childs;
    }

    public void setChilds(List<ChildBean> childs) {
        this.childs = childs;
    }
}
