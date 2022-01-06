// Author : evan lee
// Time ： 2022-01-06  11:52
// FILENAME : Customer.java
// STATEMENT: 代表客户角色，属性

package com.codewolf.moviebuy.beans;

import java.util.HashMap;
import java.util.Map;

public class Customer extends User {
    public Customer() {

    }

    public Customer(String loginName, String password, String trueName, Gender gender, String tel, Double accountNum, Map<String, Boolean> buyMovies) {
        super(loginName, password, trueName, gender, tel, accountNum);
        this.buyMovies = buyMovies;
    }

    // 定义一个属性存储购买记录。
    private Map<String, Boolean> buyMovies = new HashMap<>();

    public Map<String, Boolean> getBuyMovies() {
        return buyMovies;
    }

    public void setBuyMovies(Map<String, Boolean> buyMovies) {
        this.buyMovies = buyMovies;
    }
}
