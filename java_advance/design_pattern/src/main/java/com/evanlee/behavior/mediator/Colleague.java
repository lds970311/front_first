// Author : evan lee
// Time ： 2022-03-14  17:26
// FILENAME : Colleague.java
// STATEMENT: 

package com.evanlee.behavior.mediator;

//抽象同事类
public abstract class Colleague {
    protected String name;
    protected Mediator mediator;

    public Colleague(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
