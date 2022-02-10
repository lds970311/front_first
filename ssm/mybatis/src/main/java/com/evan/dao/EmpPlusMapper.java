// Author : evan lee
// Time ： 2022-02-10  22:12
// FILENAME : EmpPlusMapper.java
// STATEMENT: 

package com.evan.dao;

import com.evan.domain.Department;
import com.evan.domain.EmployeePlus;

public interface EmpPlusMapper {
    EmployeePlus getEmployeeById(Integer id);

    Department getDepartmentById(Integer id);

    EmployeePlus getEmployeeByStep(Integer id);
}
