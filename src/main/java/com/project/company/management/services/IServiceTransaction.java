package com.project.company.management.services;

import com.project.company.management.domain.entities.Transaction;

import java.util.List;

public interface IServiceTransaction {

    //Crear Movimiento
    public Transaction create(Transaction transaction);

    //Obtener lista de movimientos de una empresa
    public List<Transaction> findAllByEnterprise(Long id);

    //Obtener total monto de movimientos de una empresa
    public float totalAmount(Long id);



}
