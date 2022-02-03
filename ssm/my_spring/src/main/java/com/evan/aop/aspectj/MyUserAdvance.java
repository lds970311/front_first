// AUTHOR: CSR丶SUSE
// TIME : 2022-02-02  20:57
// FILENAME: MyUserAdvance.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: MyUser增强类


package com.evan.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect //生成代理对象
public class MyUserAdvance {
    //前置通知
    @Before(value = "execution(* com.evan.aop.aspectj.MyUser.add(..))") //表示作为前置通知
    public void before() {
        System.out.println("before...");
    }

    @After(value = "execution(* com.evan.aop.aspectj.MyUser.add(..))")
    public void after() {
        System.out.println("after");
    }

    //环绕通知
    @Around(value = "execution(* com.evan.aop.aspectj.MyUser.delete(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("before surround...");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("after surround...");
    }

    //后置通知（返回通知）
    @AfterReturning(value = "execution(* com.evan.aop.aspectj.MyUser.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning.........");
    }

    @AfterThrowing(value = "execution(* com.evan.aop.aspectj.MyUser.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing.........");
    }

    //相同切入点抽取
    @Pointcut(value = "execution(* com.evan.aop.aspectj.MyUser.add(..))")
    public void pointDemo() {
        System.out.println("pointdemo");
    }
}
