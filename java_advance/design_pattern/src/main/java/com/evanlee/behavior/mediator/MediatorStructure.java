// Author : evan lee
// Time ： 2022-03-14  17:30
// FILENAME : MediatorStructure.java
// STATEMENT: 

package com.evanlee.behavior.mediator;

import lombok.Getter;
import lombok.Setter;

//中介机构
public class MediatorStructure extends Mediator {
    //首先中介结构必须知道所有房主和租房者的信息
    @Getter
    @Setter
    private HouseOwner houseOwner;
    @Getter
    @Setter
    private Tenant tenant;


    @Override
    public void contact(String message, Colleague colleague) {
        if (colleague == houseOwner) {
            //如果是房主，则租房者获得信息
            tenant.getMessage(message);
        } else {
            //反正则是房主获得信息
            houseOwner.getMessage(message);
        }
    }
}
