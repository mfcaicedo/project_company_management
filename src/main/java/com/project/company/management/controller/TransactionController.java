package com.project.company.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    @GetMapping("/Transaction")
    public String TransactionList(){
        return "Lista de transacciones";
    }
}
