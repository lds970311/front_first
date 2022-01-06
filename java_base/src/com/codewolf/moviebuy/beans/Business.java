// Author : evan lee
// Time ： 2022-01-06  11:49
// FILENAME : Business.java
// STATEMENT: Business类代表商家角色，属性：店铺名称、地址

package com.codewolf.moviebuy.beans;

import lombok.Getter;
import lombok.Setter;

public class Business extends User {
    @Getter
    @Setter
    private String businessName;
    @Setter
    @Getter
    private String address;

    public Business() {
    }


    public Business(String loginName, String password, String trueName, Gender gender, String tel, Double accountNum, String businessName, String address) {
        super(loginName, password, trueName, gender, tel, accountNum);
        this.businessName = businessName;
        this.address = address;
    }
}
