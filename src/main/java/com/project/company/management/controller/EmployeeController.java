package com.project.company.management.controller;

import com.project.company.management.domain.Employee;
import com.project.company.management.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService serviceEmployee;
    public EmployeeController(){
        this.serviceEmployee = new EmployeeService();
    }
    @GetMapping("/employee")
    public List EmployeeList(){
        return this.serviceEmployee.getEmployeeList();
    }
}
