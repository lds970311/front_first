// AUTHOR: CSR丶SUSE
// TIME : 2022-02-07  11:58
// FILENAME: EmployeeController.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.mvc.controller;

import com.evan.mvc.domain.Employee;
import com.evan.mvc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    private EmpService empService;

    @GetMapping("/employee")
    public ModelAndView getAllEmployees() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("empList", empService.getAll());
        modelAndView.setViewName("employee_list");
        return modelAndView;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") Integer id) {
        empService.deleteById(id);
        return "redirect:/employee";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee) {
        empService.addEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String getEmployeeById(@PathVariable("id") Integer id, Model model) {
        Employee employee = empService.getOne(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee) {
        empService.updateEmployee(employee);
        return "redirect:/employee";
    }
}
