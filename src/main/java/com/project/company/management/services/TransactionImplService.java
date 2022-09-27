package com.project.company.management.services;

import com.project.company.management.domain.entities.Enterprise;
import com.project.company.management.domain.entities.Transaction;
import com.project.company.management.repositories.IRepositoryTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionImplService implements ITransactionService{
    @Autowired
    IRepositoryTransaction repositoryTransaction;

    @Override
    public List<Transaction> findAllByEnterprise(Long id) {
        List<Transaction> auxLstTransaction = new ArrayList<>();
        //auxLstTransaction.addAll(repositoryTransaction.findByEnterprise(id));
        repositoryTransaction.findByEnterprise(id).forEach(auxLstTransaction::add);
        return auxLstTransaction;
    }

    @Override
    public Long totalAmount(Long id) {

        return repositoryTransaction.totalAmount(id);
    }

    @Override
    public List<Transaction> findAll() {
        return (List<Transaction>) repositoryTransaction.findAll();
    }

    @Override
    public Transaction findById(Long id) {
        return repositoryTransaction.findById(id).orElse(null);
    }

    @Override
    public Transaction create(Transaction transaction) {
        return repositoryTransaction.save(transaction);
    }

    @Override
    public Transaction update(Long id, Transaction transaction) {
        return null;
    }

    @Override
    public Transaction update(Transaction transaction) {
        return repositoryTransaction.save(transaction);
    }

    @Override
    public Transaction updateTransactionById(Long id, Long idTransaction, Transaction transaction) {
        //TODO actualizar la transacción
        //1. Buscamos si existe una transacción en una determinada empresa
        Transaction transaction1 = repositoryTransaction.saveTransactionEnterprise(id,idTransaction, transaction);
        transaction1.setAmount(transaction.getAmount());
        transaction1.setConcept(transaction.getConcept());
        //transaction1.setEmployee(transaction.getEmployee());
        //transaction1.setEnterprise(transaction.ge);
        return repositoryTransaction.save(transaction1);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        //TODO eliminar una transacción de una empresa especifica
        repositoryTransaction.deleteById(id);
    }
}
