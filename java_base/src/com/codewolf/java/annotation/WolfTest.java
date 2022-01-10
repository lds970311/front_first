// Author : evan lee
// Time ： 2022-01-09  18:55
// FILENAME : WolfTest.java
// STATEMENT: 

package com.codewolf.java.annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class WolfTest {
    @Wolf(name = "西伯利亚狼", location = "苏联")
    public void wolf() {

    }

    public static void main(String[] args) {
        //解析注解
        Class<WolfTest> wolfTestClass = WolfTest.class;
        try {
            Method wolf = wolfTestClass.getDeclaredMethod("wolf");
            Annotation[] annotations = wolf.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                Wolf w = (Wolf) annotation;
                System.out.println(w.name() + ":" + w.location());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
