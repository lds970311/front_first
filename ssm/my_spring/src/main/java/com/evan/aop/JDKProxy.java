// AUTHOR: CSR丶SUSE
// TIME : 2022-02-01  23:02
// FILENAME: JDKProxy.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: JDK动态代理


package com.evan.aop;

import com.evan.aop.dao.CartDao;
import com.evan.aop.impl.CartDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


public class JDKProxy {
    public static final Logger logger = LoggerFactory.getLogger(JDKProxy.class);

    public static void main(String[] args) {
        CartDao cartDao = new CartDaoImpl();
        Class<?>[] interfaces = {CartDao.class};
        CartDao cartDaoProxy = (CartDao) Proxy.newProxyInstance(cartDao.getClass().getClassLoader(), interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                //方法之前
                logger.info("方法之前执行...." + method.getName() + " :传递的参数..." + Arrays.toString(objects));
                //被增强的方法执行
                Object res = method.invoke(cartDao, objects);
                //方法之后
                logger.warn("方法之后执行...." + cartDao);
                return res;
            }
        });

        int i = cartDaoProxy.addCart(3, 4);
        System.out.println(i);
        System.out.println(cartDao.update("1"));
    }
}
