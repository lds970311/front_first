// Author : evan lee
// Time ： 2022-01-23  20:33
// FILENAME : ProxyTest.java
// STATEMENT: 

package com.evan.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Man man = new Man("zs");

        Ticket instance = (Ticket) Proxy.newProxyInstance(man.getClass().getClassLoader(), man.getClass().getInterfaces(), (proxy, method, args1) -> method.invoke(man, args1));

        System.out.println(instance.buyTicket());
    }
}
