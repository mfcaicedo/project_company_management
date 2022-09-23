package com.project.company.management.services;

import com.project.company.management.domain.entities.Employee;
import com.project.company.management.domain.entities.Enterprise;

import java.util.List;
import java.util.Optional;

public interface IServiceEmployee {

    public List<Employee> findAll();

    public Employee findById(Long id);

    public Employee create(Employee prmEmployee);

    public Employee update(Long id, Employee prmEmployee);

    public Employee update(Employee employee);

    public boolean deleteById(Long id);

    public Employee findByName(Long id);

}
