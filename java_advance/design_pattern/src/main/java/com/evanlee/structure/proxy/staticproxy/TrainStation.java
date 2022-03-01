// Author : evan lee
// Time ： 2022-03-01  15:13
// FILENAME : TrainStation.java
// STATEMENT: 

package com.evanlee.structure.proxy.staticproxy;

//火车站  火车站具有卖票功能，所以需要实现SellTickets接口
public class TrainStation implements SellTickets {

    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
