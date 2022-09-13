package com.project.company.management.repositories;

import com.project.company.management.domain.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IRepositoryEmployee extends CrudRepository<Employee, Long> {

}
