// Author : evan lee
// Time ： 2022-02-12  22:22
// FILENAME : EmpStatus.java
// STATEMENT: 

package com.evan.mybatis.beans;

import lombok.Getter;

public enum EmpStatus {
    LOGIN(100, "登录"),
    LOGOUT(200, "登出"),
    REMOVED(400, "用户不存在");

    @Getter
    private Integer code;
    @Getter
    private String message;

    EmpStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static EmpStatus getStatusByCode(Integer code) {
        switch (code) {
            case 100:
                return LOGIN;
            case 200:
                return LOGOUT;
            case 400:
                return REMOVED;
            default:
                return LOGOUT;
        }
    }
}
