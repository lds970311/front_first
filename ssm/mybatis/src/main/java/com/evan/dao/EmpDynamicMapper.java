// Author : evan lee
// Time ： 2022-02-11  14:01
// FILENAME : EmpDynamicMapper.java
// STATEMENT: 

package com.evan.dao;

import com.evan.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDynamicMapper {
    Employee getDynamicEmployee(Employee employee);

    void updateDynamicEmployee(Employee employee);

    List<Employee> getEmployees(@Param("ids") List<Integer> ids);
}
