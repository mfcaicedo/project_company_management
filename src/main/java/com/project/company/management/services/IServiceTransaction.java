package com.project.company.management.services;

import com.project.company.management.domain.entities.Transaction;

import java.util.List;

public interface IServiceTransaction {
    //GET
    public List<Transaction> findAllByEnterprise(long id);


}
