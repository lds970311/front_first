// Author : evan lee
// Time ： 2022-03-10  0:51
// FILENAME : WatcherTest.java
// STATEMENT: 

package com.evanlee.behavior;

import com.evanlee.behavior.watcher.Subject;
import com.evanlee.behavior.watcher.SubscriptionSubject;
import com.evanlee.behavior.watcher.WeixinUser;
import org.junit.jupiter.api.Test;


//观察者模式测试
public class WatcherTest {
    @Test
    void subscribe() {
        Subject subject = new SubscriptionSubject();
        subject.attach(new WeixinUser("zs"));
        subject.attach(new WeixinUser("ls"));
        subject.attach(new WeixinUser("lucy"));
        subject.attach(new WeixinUser("tom"));
        subject.notify("今天天气咋样?");
    }
}
