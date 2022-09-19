package com.project.company.management.repositories;

import com.project.company.management.domain.entities.Transaction;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepositoryTransaction extends CrudRepository<Transaction, Long> {
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface IRepositoryTransaction extends JpaRepository<Transaction,Long> {
>>>>>>> devBrandon
    //Lista de movimientos de una empresa
    @Query(value = "select * from Transaction where enterprise_id= ?1", nativeQuery = true)
    public abstract List<Transaction> findByEnterprise(long id);

<<<<<<< HEAD
=======
    //ME PERMITE REPRESENTAR CONSULTAS DE BASES DE DATOS EN SPRINGBOOT
>>>>>>> devBrandon
    //Total Monto de movimientos de una empresa especifica
    @Query(value = "select sum(amount) from Transaction where enterprise_id= ?1",nativeQuery = true)
    public abstract float totalAmount(long id);

<<<<<<< HEAD
    //Guardar movimiento de una empresa especifica
    @Query(value = "select * from Transaction where enterprise_id = ?1 and id = ?2", nativeQuery = true)
    public abstract  Transaction saveTransactionEnterprise(long idEnterprise, long idTransaction, Transaction transaction);

    //Consultar si existe una transacción en una empresa específica
    @Query(value = "delete from Transaction where enterprise_id = ?1 and id = ?2", nativeQuery = true)
    public abstract  boolean deleteTransactionEnterprise(long idEnterprise, long idTransaction);
=======


>>>>>>> devBrandon
}
