// AUTHOR: CSR丶SUSE
// TIME : 2022-02-02  20:56
// FILENAME: MyUser.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.aop.aspectj;

import org.springframework.stereotype.Component;

//被增强类-
@Component
public class MyUser {
    public void add() {
        System.out.println("add ....");
    }

    public void delete() {
        System.out.println("delete");
    }
}
