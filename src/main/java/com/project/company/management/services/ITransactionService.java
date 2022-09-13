package com.project.company.management.services;

import com.project.company.management.domain.entities.Employee;
import com.project.company.management.domain.entities.Transaction;

import java.util.List;

public interface ITransactionService {

    //Obtener lista de movimientos de una empresa
    public List<Transaction> findAllByEnterprise(Long id);

    //Obtener total monto de movimientos de una empresa
    public float totalAmount(Long id);

    /**
     * Listar todas las Transaction
     * @return
     */
    public List<Transaction> findAll();

    /**
     * Encontrar Transaction por id
     *
     * @param id
     * @return
     */
    public Transaction findById(Long id);

    /**
     * Crear un Transaction
     * @param transaction
     * @return
     */
    public Transaction create(Transaction transaction);

    /**}
     * Actualizar una Transaction con id
     * @param id identificador de la transacción a actualizar
     * @param transaction objeto de empresa a editar
     * @return Empresa con los datos actualizados
     */
    public Transaction update(Long id, Transaction transaction);

    public Transaction updateTransactionById(Long id, Long idTransaction, Transaction transaction);
    /**
     * Eliminar una Transaction con id
     * @param id identificador de la transacción a eliminar
     */
    public void deleteById(Long id);
}
