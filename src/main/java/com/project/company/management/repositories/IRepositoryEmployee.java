package com.project.company.management.repositories;

import com.project.company.management.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IRepositoryEmployee extends JpaRepository<Employee, Long> {

    public Employee findByEmail (String email);
}
