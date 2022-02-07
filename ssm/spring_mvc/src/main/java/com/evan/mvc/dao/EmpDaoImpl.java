// AUTHOR: CSR丶SUSE
// TIME : 2022-02-07  11:19
// FILENAME: EmpDaoImpl.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.mvc.dao;

import com.evan.mvc.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDaoImpl implements EmpDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAll() {
        String sql = "select * from jdbctemplate.employee";
        List<Employee> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
        return query;
    }

    @Override
    public Employee getOne(Integer id) {
        String sql = "select * from jdbctemplate.employee where id = ?";
        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
        return employee;
    }

    @Override
    public Integer deleteById(Integer id) {
        String sql = "delete from jdbctemplate.employee where id = ?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "update jdbctemplate.employee set lastName = ?, email = ?,gender = ? where id = ?";
        jdbcTemplate.update(sql, employee.getLastName(), employee.getEmail(), employee.getGender(), employee.getId());
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "insert into jdbctemplate.employee(lastName, email, gender) value (?,?,?)";
        jdbcTemplate.update(sql, employee.getLastName(), employee.getEmail(), employee.getGender());
    }
}
