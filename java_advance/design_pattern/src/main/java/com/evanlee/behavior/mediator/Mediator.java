// Author : evan lee
// Time ： 2022-03-14  17:25
// FILENAME : Mediator.java
// STATEMENT: 

package com.evanlee.behavior.mediator;

//抽象中介者
public abstract class Mediator {
    //申明一个联络方法
    public abstract void contact(String message, Colleague colleague);
}
