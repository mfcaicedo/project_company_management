package com.project.company.management.repositories;

import com.project.company.management.domain.entities.Employee;
import org.springframework.data.repository.CrudRepository;
<<<<<<< HEAD

public interface IRepositoryEmployee extends CrudRepository<Employee, Long> {
=======
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryEmployee extends CrudRepository<Employee,Long> {
>>>>>>> devBrandon

}
