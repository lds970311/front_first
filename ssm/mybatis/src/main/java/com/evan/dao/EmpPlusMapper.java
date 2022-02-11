// Author : evan lee
// Time ： 2022-02-10  22:12
// FILENAME : EmpPlusMapper.java
// STATEMENT: 

package com.evan.dao;

import com.evan.domain.Department;
import com.evan.domain.DepartmentPlus;
import com.evan.domain.Employee;
import com.evan.domain.EmployeePlus;

import java.util.List;

public interface EmpPlusMapper {
    EmployeePlus getEmployeeById(Integer id);

    Department getDepartmentById(Integer id);

    EmployeePlus getEmployeeByStep(Integer id);

    DepartmentPlus getDepartmentAndEmpById(Integer id);

    DepartmentPlus getDepartmentAndEmpByIdByStep(Integer id);

    List<EmployeePlus> getNormalEmployeeById(Integer id);
}
