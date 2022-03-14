// Author : evan lee
// Time ： 2022-03-10  0:46
// FILENAME : Observer.java
// STATEMENT: 

package com.evanlee.behavior.watcher;

//定义抽象观察者类，里面定义一个更新的方法
public interface Observer {
    void update(String message);
}
