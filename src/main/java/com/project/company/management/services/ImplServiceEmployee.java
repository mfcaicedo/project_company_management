package com.project.company.management.services;

import com.project.company.management.domain.entities.Employee;
import com.project.company.management.repositories.IRepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplServiceEmployee implements IServiceEmployee {
    //para inyectar en la variable anotada un objeto nuevo del tipo indicado
    @Autowired
    //DUDA YA QUE EL REPOSITORIO YA ESTA IMPLEMENTADO PERO LO PIDEN EN EL SPRINT 4!!!!!!!!!!!!!!!!!!!!
    private IRepositoryEmployee repositoryEmployee;

    public ImplServiceEmployee(IRepositoryEmployee repositoryEmployee) {
        this.repositoryEmployee = repositoryEmployee;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> auxLstEmployee= new ArrayList<>();
        repositoryEmployee.findAll().forEach(auxLstEmployee::add);
        return auxLstEmployee;
    }

    @Override
    public Employee findById(Long id) {
        Employee employee = repositoryEmployee.findById(id).orElse(null);
        return employee;
    }

    @Override
    public Employee create(Employee prmEmployee) {
        return  repositoryEmployee.save(prmEmployee);
    }

    @Override
    public Employee update(Long id, Employee prmEmployee) {
        Employee employee = this.findById(id);
        employee.setName(prmEmployee.getName());
        employee.setRole(prmEmployee.getRole());
        employee.setEmail(prmEmployee.getEmail());
        employee.setId(prmEmployee.getId());
        employee.setUpdatedAt(prmEmployee.getUpdatedAt());
        employee.setEnterprise(prmEmployee.getEnterprise());
        employee.setProfile(prmEmployee.getProfile());
        employee.setTransaction(prmEmployee.getTransaction());
        employee.setCreatedAt(prmEmployee.getCreatedAt());

        return repositoryEmployee.save(employee);
    }

    @Override
    public boolean deleteById(Long id) {
        repositoryEmployee.deleteById(id);
        if (repositoryEmployee.findById(id).isPresent()){
            return false;
        }
        return true;
    }

    @Override
    public Employee findByName(Long id) {
        return null;
    }



}
