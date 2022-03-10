// Author : evan lee
// Time ： 2022-03-10  0:47
// FILENAME : WeixinUser.java
// STATEMENT: 

package com.evanlee.watcher;

@SuppressWarnings("all")
public class WeixinUser implements Observer {

    // 微信用户名
    private String name;

    public WeixinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
