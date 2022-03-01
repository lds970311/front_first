// Author : evan lee
// Time ： 2022-03-01  16:17
// FILENAME : GglibProxy.java
// STATEMENT: 

package com.evanlee.structure.proxy.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private final TrainStation station = new TrainStation();

    public TrainStation getProxyStation() {
        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置父类的字节码对象
        enhancer.setSuperclass(station.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建代理对象
        return (TrainStation) enhancer.create();
    }

    @Override
      /*
        intercept方法参数说明：
            o ： 代理对象
            method ： 真实对象中的方法的Method实例
            args ： 实际参数
            methodProxy ：代理对象中的方法的method实例
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理点收取一些服务费用(CGLIB动态代理方式)");
        //调用目标对象的方法
        return methodProxy.invoke(station, objects);
    }
}
