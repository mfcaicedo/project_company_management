package com.project.company.management.repositories;

import com.project.company.management.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface IRepositoryEmployee extends JpaRepository<Employee, Long> {

    @Query(value = "select * from employee where email=?1",nativeQuery = true)
    public Employee findByEmail (String email);
}
