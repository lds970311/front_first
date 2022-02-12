// Author : evan lee
// Time ： 2022-02-11  22:59
// FILENAME : EmployeeController.java
// STATEMENT: 

package com.evan.controller;

import com.evan.domain.Employee;
import com.evan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmployees", allEmployees);
        return "employee_list";
    }
}
