// Author : evan lee
// Time ： 2022-02-11  23:01
// FILENAME : EmplyeeService.java
// STATEMENT: 

package com.evan.service;

import com.evan.dao.EmpMapper;
import com.evan.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmpMapper empMapper;

    public List<Employee> getAllEmployees() {
        return empMapper.getAllEmployees();
    }
}
