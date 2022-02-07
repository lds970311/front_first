// AUTHOR: CSR丶SUSE
// TIME : 2022-02-07  11:19
// FILENAME: EmpServiceImpl.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.mvc.service;

import com.evan.mvc.dao.EmpDao;
import com.evan.mvc.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public List<Employee> getAll() {
        return empDao.getAll();
    }

    @Override
    public Employee getOne(Integer id) {
        return empDao.getOne(id);
    }

    @Override
    public Integer deleteById(Integer id) {
        return empDao.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        empDao.updateEmployee(employee);
    }

    @Override
    public void addEmployee(Employee employee) {
        empDao.addEmployee(employee);
    }
}
