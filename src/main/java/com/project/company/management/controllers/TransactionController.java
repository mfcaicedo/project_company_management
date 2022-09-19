package com.project.company.management.controllers;

import com.project.company.management.domain.entities.Employee;
import com.project.company.management.domain.entities.Enterprise;
import com.project.company.management.domain.entities.Transaction;
import com.project.company.management.services.IEmployeeService;
import com.project.company.management.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TransactionController {
    @Autowired
    private ITransactionService serviceTransaction;

    /**
     * Obtener todas las transacciones
     * @return lista de las transacciones
     */
    @GetMapping("movements/")
    public List<Transaction> getAll(){
        return serviceTransaction.findAll();
    }

    /**
     * Obtener una transacciones especifica
     * @param id identificador de la transacción a buscar
     * @return objeto de la transacción encontrada
     */
    @GetMapping("movements/{id}")
    public Transaction getById(@PathVariable("id") Long id){
        return serviceTransaction.findById(id);
    }

    /**
     * Obtener transacciones de una empresa específica
     * @param id identificación de la empresa
     * @return
     */
    @GetMapping("/enterprises/{id}/movements")
    public List<Transaction> getAllByEnterprise(@PathVariable("id") Long id){
        return serviceTransaction.findAllByEnterprise(id);
    }

    /**
     * Crear un movimiento (transaccción)
     * @param transaction objecto con los atributos
     * @return
     */
    @RequestMapping(value = "/movements/",method = RequestMethod.POST, produces = "application/json")
    public Transaction create(@RequestBody Transaction transaction){
        return serviceTransaction.create(transaction);
    }

    /**
     * Obtener el total de montos de movimientos de una empresa específica
     * @param id de la empresa a consultar sus movimientos
     * @return
     */
    @GetMapping("/enterprises/{id}/total")
    public float totalAmount(@PathVariable Long id){
        return serviceTransaction.totalAmount(id);
    }

    /**
     * Método para actualizar un movimiento de una determinada empresa
     * @param transaction objeto de transacción a actualizar
     * @param id identificador de la transacción a actualizar
     * @return
     */
    @RequestMapping(value = "enterprises/{id}/movements/{idTransaction}", method = RequestMethod.PATCH, produces= "application/json")
    @ResponseBody
    public Transaction updateTransactionEnterprises(@RequestBody Transaction transaction, @PathVariable Long id, @PathVariable Long idTransaction) {
        return serviceTransaction.updateTransactionById(id, idTransaction, transaction);
    }

    /**
     * Método para eliminar una transacción
     * @param id identificador de la transacción a eliminar
     */
    @RequestMapping(value = "movements/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        serviceTransaction.deleteById(id);
    }
}
