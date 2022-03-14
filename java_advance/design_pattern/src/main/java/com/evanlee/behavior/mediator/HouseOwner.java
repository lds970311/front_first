// Author : evan lee
// Time ： 2022-03-14  17:27
// FILENAME : HouseOwner.java
// STATEMENT: 

package com.evanlee.behavior.mediator;

//具体同事类 房屋拥有者
public class HouseOwner extends Colleague {

    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    //与中介者联系
    public void contact(String message) {
        mediator.contact(message, this);
    }

    //获取信息
    public void getMessage(String message) {
        System.out.println("房主" + name + "获取到的信息：" + message);
    }
}
