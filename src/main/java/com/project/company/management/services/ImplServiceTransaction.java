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
    public List<Transaction> findAllByEnterprise(long id) {
        List<Transaction> auxLstTransaction = new ArrayList<>();
        repositoryTransaction.findByEnterprise(id).forEach(auxLstTransaction::add);
        return auxLstTransaction;
    }


}
