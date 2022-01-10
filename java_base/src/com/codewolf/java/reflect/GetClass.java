// Author : evan lee
// Time ： 2022-01-09  16:31
// FILENAME : GetClass.java
// STATEMENT: 

package com.codewolf.java.reflect;

import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class GetClass {

    @SneakyThrows
    @Test
    public void getClassTest() {
        try {
            Class<?> cls = Class.forName("com.codewolf.java.reflect.TestCls");
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(String.class, Integer.class);
            TestCls testCls = (TestCls) declaredConstructor.newInstance("123", 12);
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getType()); //class java.lang.String
                System.out.println(field.getName()); //name
            }

            Field name = cls.getDeclaredField("name");
            name.setAccessible(true); //设置私有字段可见性
            TestCls cls1 = new TestCls();
            name.set(cls1, "Sam"); //给对象属性辅助

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Test
    public void getMethodTest() {
        try {
            Class<?> cls = Class.forName("java.util.HashMap");

            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.printf("name=%s,type=%s, count=%d\n", method.getName(), method.getReturnType(), method.getParameterCount());
            }
            Method put = cls.getDeclaredMethod("put", Object.class, Object.class);
            put.setAccessible(true);
            HashMap<String, Integer> map = new HashMap<>();
            Object amount = put.invoke(map, "amount", 11);
            System.out.println(amount);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
