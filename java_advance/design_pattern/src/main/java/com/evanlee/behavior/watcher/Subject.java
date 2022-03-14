// Author : evan lee
// Time ： 2022-03-10  0:48
// FILENAME : Subject.java
// STATEMENT: 

package com.evanlee.behavior.watcher;

//定义抽象主题类，提供了attach、detach、notify三个方法
@SuppressWarnings("all")
public interface Subject {
    /**
     * 添加订阅者
     *
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 移除订阅者
     *
     * @param observer
     * @return
     */
    boolean detach(Observer observer);

    /**
     * 发布消息通知
     *
     * @param message
     */
    void notify(String message);
}
