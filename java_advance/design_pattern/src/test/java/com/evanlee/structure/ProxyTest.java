// Author : evan lee
// Time ： 2022-03-01  15:16
// FILENAME : StaticProxyTest.java
// STATEMENT: 

package com.evanlee.structure;

import com.evanlee.structure.proxy.dynamic.CglibProxy;
import com.evanlee.structure.proxy.dynamic.ProxyFactory;
import com.evanlee.structure.proxy.dynamic.TrainStation;
import com.evanlee.structure.proxy.staticproxy.ProxyPoint;
import com.evanlee.structure.proxy.staticproxy.SellTickets;
import org.junit.jupiter.api.Test;

public class ProxyTest {
    @Test
    void proxyTest() {
        ProxyPoint proxyPoint = new ProxyPoint();
        proxyPoint.sell();
    }

    @Test
    void proxyFactoryTest() {
        ProxyFactory proxyFactory = new ProxyFactory();
        SellTickets sellTickets = proxyFactory.getProxyObject();
        sellTickets.sell();
        System.out.println(sellTickets.getClass());

        //让程序一直运行
        while (true) {

        }
    }

    @Test
    void cglibProxyTest() throws InterruptedException {
        CglibProxy cglibProxy = new CglibProxy();
        TrainStation proxyStation = cglibProxy.getProxyStation();
        proxyStation.sell();

        System.out.println(proxyStation.getClass());
        Thread.sleep(10000000);
    }
}
