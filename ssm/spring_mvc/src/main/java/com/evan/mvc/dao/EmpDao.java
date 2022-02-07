// AUTHOR: CSR丶SUSE
// TIME : 2022-02-07  11:19
// FILENAME: EmpDao.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.mvc.dao;

import com.evan.mvc.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpDao {
    List<Employee> getAll();

    Employee getOne(Integer id);

    Integer deleteById(Integer id);

    void updateEmployee(Employee employee);

    void addEmployee(Employee employee);
}
