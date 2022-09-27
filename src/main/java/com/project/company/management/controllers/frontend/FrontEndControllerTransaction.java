package com.project.company.management.controllers.frontend;

import com.project.company.management.domain.entities.Transaction;
import com.project.company.management.services.IEmployeeService;
import com.project.company.management.services.IEnterpriseService;
import com.project.company.management.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontEndControllerTransaction {
    @Autowired
    private ITransactionService serviceTransaction;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    private IEnterpriseService enterpriseService;

    //OBTENER TRANSACCIONES(MOVIMIENTOS) DE UNA EMPRESA ESPECIFICA

    @GetMapping("/enterprises/movements/{id}")
    public String getAllByEnterprise(@PathVariable Long id, Model model){
        model.addAttribute("transactions", serviceTransaction.findAllByEnterprise(id));
        model.addAttribute("total", serviceTransaction.totalAmount(id));
        return "transactions";
    }

    //EDITAR MOVIMIENTO
    @GetMapping("/transaction/editar/{id}")
    public String formUpdate(@PathVariable Long id, Model model){
        model.addAttribute("transaction",serviceTransaction.findById(id));
        model.addAttribute("employees",employeeService.findAll());
        model.addAttribute("enterprises",enterpriseService.findAll());
        return "update-transaction";
    }

    @PostMapping("/transaction/{id}")
    public String updateTransaction(@PathVariable Long id, @ModelAttribute("transaction")Transaction transaction, Model model){
        Transaction transactionExist = serviceTransaction.findById(id);
        transactionExist.setAmount(transaction.getAmount());
        transactionExist.setConcept(transaction.getConcept());
        transactionExist.setEmployee(transaction.getEmployee());
        transactionExist.setEnterprise(transaction.getEnterprise());
        serviceTransaction.update(transactionExist);
        return "redirect:/enterprises";
    }

    //AGREGAR MOVIMIENTO
    @GetMapping("/transaction/crear")
    public String formCreate(Model model){
        Transaction transaction= new Transaction();
        model.addAttribute("transaction",transaction);
        model.addAttribute("employees",employeeService.findAll());
        model.addAttribute("enterprises",enterpriseService.findAll());
        return "add-transaction";

    }

    @PostMapping("/transaction")
    public String formSave(@ModelAttribute("transaction") Transaction transaction){
        serviceTransaction.create(transaction);
        return "redirect:/enterprises";
    }

    //ELIMINAR MOVIMIENTO
    @GetMapping("/transaction/delete/{id}")
    public String deleteTransaction(@PathVariable Long id){
        serviceTransaction.deleteById(id);
        return "redirect:/enterprises";
    }




}
