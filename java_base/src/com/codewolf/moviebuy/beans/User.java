// Author : evan lee
// Time ： 2022-01-06  11:46
// FILENAME : User.java
// STATEMENT: 定义User类作为父类，属性：登录名称、密码、真实名称、性别、电话、账户金额

package com.codewolf.moviebuy.beans;

import lombok.Data;

@Data
public abstract class User {
    private String loginName;
    private String password;
    private String trueName;
    private Gender gender;
    private String tel;
    private Double accountNum;

    public User() {
    }

    public User(String loginName, String password, String trueName, Gender gender, String tel, Double accountNum) {
        this.loginName = loginName;
        this.password = password;
        this.trueName = trueName;
        this.gender = gender;
        this.tel = tel;
        this.accountNum = accountNum;
    }
}
