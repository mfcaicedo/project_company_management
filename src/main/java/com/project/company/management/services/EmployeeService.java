package com.project.company.management.services;

import com.project.company.management.domain.Employee;
import com.project.company.management.domain.Transaction;

import java.util.List;

public class EmployeeService {

    Employee Employee1;
    Employee Employee2;
    List<Employee> EmployeeList;



    public EmployeeService(){
        this.Employee1=  new Employee();
        this.Employee1.setName("Javier");
        this.Employee1.setEmail("Javierramirez.m93@gmail.com");

        this.Employee2=  new Employee();
        this.Employee2.setName("Jacobo");
        this.Employee2.setEmail("JacoboRamirez@gmail.com");
        this.EmployeeList.add(Employee1);
        this.EmployeeList.add(Employee2);

    }


    public List getEmployeeList(){
        return this.EmployeeList;
    }

}
