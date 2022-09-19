package com.project.company.management.services;

import com.project.company.management.domain.entities.Employee;
import com.project.company.management.domain.entities.Enterprise;
import com.project.company.management.domain.entities.Profile;
import com.project.company.management.repositories.IRepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeImplService implements  IEmployeeService{

    //Inyección de dependencias
    @Autowired
    private IRepositoryEmployee repositoryEmployee;

    @Override
    public List<Employee> findAll() {
        return (List<Employee>)repositoryEmployee.findAll();
    }

    @Override
    public Employee findById(Long id) {
        Employee employee1 = repositoryEmployee.findById(id).orElse(null);
        return  employee1;
    }

    @Override
    public Employee create(Employee employee) {
        return repositoryEmployee.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Employee employee1 = this.findById(id);
        employee1.setName(employee.getName());
        employee1.setRole(employee.getRole());
        employee1.setEmail(employee.getEmail());
        employee1.setCreatedAt(employee.getCreatedAt());
        employee1.setUpdatedAt(employee.getUpdatedAt());
        return repositoryEmployee.save(employee1);
    }

    @Override
    public void deleteById(Long id) {
        repositoryEmployee.deleteById(id);
    }
}
