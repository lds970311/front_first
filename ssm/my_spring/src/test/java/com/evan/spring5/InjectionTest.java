// AUTHOR: CSR丶SUSE
// TIME : 2022-01-31  23:48
// FILENAME: InjectionTest.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.spring5;

import com.evan.beans.BookStore;
import com.evan.beans.Employee;
import com.evan.domain.Order;
import com.evan.domain.Student;
import com.evan.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectionTest {
    private static final ApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("spring/beans.xml");
    }

    @Test
    public void orderTest() {
        Order order = context.getBean("order", Order.class);
        System.out.println(order);
    }

    @Test
    public void stuTest() {
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void userServiceTest() {
        UserService userService = context.getBean("userService", UserService.class);
        userService.addUser();
    }

    @Test
    public void EmpTest() {
        Employee emp = context.getBean("emp", Employee.class);
        System.out.println(emp);
        //Employee{ename='sam', gender='男', dept=Department{dname='研发部'}}
    }

    @Test
    public void bookstoreTest() {
        BookStore bookstore = context.getBean("bookstore", BookStore.class);
        System.out.println(bookstore);
    }
}
