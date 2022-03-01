// Author : evan lee
// Time ： 2022-03-01  15:24
// FILENAME : ProxyFactory.java
// STATEMENT: 

package com.evanlee.structure.proxy.dynamic;

import com.evanlee.structure.proxy.staticproxy.SellTickets;
import com.evanlee.structure.proxy.staticproxy.TrainStation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    //声明目标对象
    private final TrainStation station = new TrainStation();

    public SellTickets getProxyObject() {
         /*
            newProxyInstance()方法参数说明：
                ClassLoader loader ： 类加载器，用于加载代理类，使用真实对象的类加载器即可
                Class<?>[] interfaces ： 真实对象所实现的接口，代理模式真实对象和代理对象实现相同的接口
                InvocationHandler h ： 代理对象的调用处理程序
         */
        SellTickets proxyObject = (SellTickets) Proxy.newProxyInstance(
                station.getClass().getClassLoader(),
                station.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                     /*
                        InvocationHandler中invoke方法参数说明：
                            proxy ： 代理对象
                            method ： 对应于在代理对象上调用的接口方法的 Method 实例
                            args ： 代理对象调用接口方法时传递的实际参数
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理点收取一些服务费用(JDK动态代理方式)");
                        return method.invoke(station, args);
                    }
                }
        );
        return proxyObject;
    }
}
