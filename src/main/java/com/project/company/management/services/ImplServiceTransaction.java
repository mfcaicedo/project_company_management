package com.project.company.management.services;

import com.project.company.management.domain.entities.Transaction;
import com.project.company.management.repositories.IRepositoryTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplServiceTransaction implements IServiceTransaction{
    @Autowired
    IRepositoryTransaction repositoryTransaction;

    @Override
    public Transaction create(Transaction transaction) {
        return repositoryTransaction.save(transaction);
    }

    @Override
    public List<Transaction> findAllByEnterprise(Long id) {
        List<Transaction> auxLstTransaction = new ArrayList<>();
        repositoryTransaction.findByEnterprise(id).forEach(auxLstTransaction::add);
        return auxLstTransaction;
    }

    @Override
    public float totalAmount(Long id) {
        return repositoryTransaction.totalAmount(id);
    }


}
