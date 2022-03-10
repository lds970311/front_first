// Author : evan lee
// Time ： 2022-03-10  0:49
// FILENAME : SubscriptionSubject.java
// STATEMENT: 

package com.evanlee.watcher;

import java.util.ArrayList;
import java.util.List;

//微信公众号是具体主题（具体被观察者），里面存储了订阅该公众号的微信用户，并实现了抽象主题中的方法
public class SubscriptionSubject implements Subject {

    private final List<Observer> winxinUserList;

    public SubscriptionSubject() {
        this.winxinUserList = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        this.winxinUserList.add(observer);
    }

    @Override
    public boolean detach(Observer observer) {
        return this.winxinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        this.winxinUserList.forEach(observer -> {
            observer.update(message);
        });
    }
}
