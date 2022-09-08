package com.project.company.management.controllers;

import com.project.company.management.domain.entities.Transaction;
import com.project.company.management.services.IServiceTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerTransaction {
    @Autowired
    private IServiceTransaction serviceTransaction;

    //OBTENER TRANSACCIONES DE UNA EMPRESA ESPECIFICA
    @GetMapping("/enterprises/{id}/movements")
    public List<Transaction> getAllByEnterprise(@PathVariable("id") Long id){
        return serviceTransaction.findAllByEnterprise(id);
    }
}
