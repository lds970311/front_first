package com.evan.dao;

import com.evan.domain.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    Employee getEmployeeById(Integer id);

    boolean addEmployee(Employee employee);

    Integer updateEmployee(Employee employee);

    Integer deleteEmployee(Integer id);

    Employee getEmpByIdAndName(@Param("id") Integer id, @Param("name") String name);

    List<Employee> getEmpsByLastNameLike(String lastName);

    Map<String, Object> getEmpMap(Integer id);

    @MapKey("id")
    Map<Integer, Employee> getEmployeesMap();
}
