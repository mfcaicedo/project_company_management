package com.project.company.management.controllers;

import com.project.company.management.domain.entities.Transaction;
import com.project.company.management.services.IServiceTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ControllerTransaction {
    @Autowired
    private IServiceTransaction serviceTransaction;

    //OBTENER TRANSACCIONES(MOVIMIENTOS) DE UNA EMPRESA ESPECIFICA
    /*
    @GetMapping("/enterprises/{id}/movements")
    public List<Transaction> getAllByEnterprise(@PathVariable("id") Long id){
        return serviceTransaction.findAllByEnterprise(id);
    }
    */
    @GetMapping("/enterprises/movements/{id}")
    public String getAllByEnterprise(@PathVariable Long id, Model model){
        model.addAttribute("transactions", serviceTransaction.findAllByEnterprise(id));
        model.addAttribute("total", serviceTransaction.totalAmount(id));
        return "transactionsByEnterprise";
    }


    //CREAR MOVIMIENTO
    @RequestMapping(value = "/movements/",method = RequestMethod.POST, produces = "application/json")
    public Transaction create(@RequestBody Transaction transaction){
        return serviceTransaction.create(transaction);
    }

    //OBTENER TOTAL MONTOS DE MOVIMIENTOS DE UNA EMPRESA ESPECIFICA
    /*
    @GetMapping("/enterprises/{id}/total")
    public float totalAmount(@PathVariable Long id){
        return serviceTransaction.totalAmount(id);
    }
    */
    /*
    @GetMapping("enterprises/total/{id}")
    public String totalAmount(@PathVariable Long id, Model model){
        model.addAttribute("total",serviceTransaction.totalAmount(id));
        return "redirect:/enterprises/movements/{id}";
    }

     */





}
