package com.evan.dao;

import com.evan.domain.Employee;

public interface EmpMapper {
    Employee getEmployeeById(Integer id);

    boolean addEmployee(Employee employee);

    Integer updateEmployee(Employee employee);

    Integer deleteEmployee(Integer id);
}
