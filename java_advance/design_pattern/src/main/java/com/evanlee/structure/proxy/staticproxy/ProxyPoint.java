// Author : evan lee
// Time ： 2022-03-01  15:13
// FILENAME : ProxyPoint.java
// STATEMENT: 

package com.evanlee.structure.proxy.staticproxy;

//代售点
public class ProxyPoint implements SellTickets {

    private final TrainStation station = new TrainStation();

    @Override
    public void sell() {
        System.out.println("代理点收取一些服务费用");
        station.sell();
    }
}
