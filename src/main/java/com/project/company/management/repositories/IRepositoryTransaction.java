package com.project.company.management.repositories;

import com.project.company.management.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface IRepositoryTransaction extends JpaRepository<Transaction,Long> {
    //GET
    @Query(value = "select * from Transaction where enterprise_id= ?1", nativeQuery = true)
    public abstract List<Transaction> findByEnterprise(long id);








}
