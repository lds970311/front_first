// Author : evan lee
// Time ： 2022-03-14  17:28
// FILENAME : Tenant.java
// STATEMENT: 

package com.evanlee.behavior.mediator;

//具体同事类 房屋拥有者
public class Tenant extends Colleague {

    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    //与中介者联系
    public void contact(String message) {
        this.mediator.contact(message, this);
    }

    //获取信息
    public void getMessage(String message) {
        System.out.println("房主" + name + "获取到的信息：" + message);
    }
}
