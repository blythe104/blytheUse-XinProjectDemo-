package com.xin.xinprojectsdemo.bean;

/**
 * Created by xin on 2016/6/1.
 */
public class Category {
    public static final int SECOND_TYPE = 0;
    public static final int THIRD_TYPE = 1;
    private String categoryName;
    private int type;

    public Category(String categoryName, int type) {
        this.categoryName = categoryName;
        this.type = type;
    }

    public String getCategoryName() {
        return categoryName;
    }


    public int getType() {
        return type;
    }

}
