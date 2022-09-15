package com.project.company.management.repositories;

import com.project.company.management.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface IRepositoryTransaction extends JpaRepository<Transaction,Long> {
    //Lista de movimientos de una empresa
    @Query(value = "select * from Transaction where enterprise_id= ?1", nativeQuery = true)
    public abstract List<Transaction> findByEnterprise(long id);

    //ME PERMITE REPRESENTAR CONSULTAS DE BASES DE DATOS EN SPRINGBOOT
    //Total Monto de movimientos de una empresa especifica
    @Query(value = "select sum(amount) from Transaction where enterprise_id= ?1",nativeQuery = true)
    public abstract float totalAmount(long id);



}
