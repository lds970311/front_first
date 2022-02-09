// AUTHOR: CSR丶SUSE
// TIME : 2022-02-07  11:31
// FILENAME: EmpServiceTestr.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan;

import com.evan.mvc.domain.Employee;
import com.evan.mvc.service.EmpService;
import com.evan.mvc.service.EmpServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmpServiceTest {
    private static final EmpService empService;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("springMVC.xml");
        EmpServiceImpl empServiceImpl = context.getBean("empServiceImpl", EmpServiceImpl.class);
        empService = empServiceImpl;
    }

    @Test
    public void getAll() {
        List<Employee> all = empService.getAll();
        all.forEach(System.out::println);
    }

    @Test
    public void getOne() {
        Employee one = empService.getOne(1);
        System.out.println(one);
    }

    @Test
    public void deleteById() {
        Integer integer = empService.deleteById(1);
        System.out.println(integer);
    }

    @Test
    public void update() {
        empService.updateEmployee(new Employee(2, "A-DD", "dd@144.com", 1));
    }

    @Test
    public void addEmployee() {
        for (int i = 0; i < 5; i++) {
            empService.addEmployee(new Employee(6, "H-ee-ff", "ee-ff@133.com", 0));
            empService.addEmployee(new Employee(6, "E-ee-ff", "fe-ff@133.com", 1));
            empService.addEmployee(new Employee(6, "E-ee-ff", "He-ff@133.com", 1));
            empService.addEmployee(new Employee(6, "F-ee-ff", "Le-ff@133.com", 1));
            empService.addEmployee(new Employee(6, "G-ee-ff", "Me-ff@163.com", 0));
        }
    }

}
