package com.evan.dao;

import com.evan.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpMapper {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);
}
