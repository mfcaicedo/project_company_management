package com.project.company.management.repositories;

import com.project.company.management.domain.entities.Enterprise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryEnterprise extends CrudRepository<Enterprise, Long> {

}

