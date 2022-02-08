// AUTHOR: CSR丶SUSE
// TIME : 2022-02-07  11:05
// FILENAME: EmpService.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.mvc.service;


import com.evan.mvc.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpService {
    List<Employee> getAll();

    Employee getOne(Integer id);

    Integer deleteById(Integer id);

    void updateEmployee(Employee employee);

    void addEmployee(Employee employee);
}
