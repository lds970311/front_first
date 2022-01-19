// Author : evan lee
// Time ： 2022-01-19  20:26
// FILENAME : UserInfo.java
// STATEMENT: 

package com.evan.web.beans;

import lombok.Data;

@Data
public class UserInfo {
    private String user;
    private String password;

    public UserInfo() {
    }

    public UserInfo(String user, String password) {
        this.user = user;
        this.password = password;
    }
}
