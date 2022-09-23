package com.project.company.management.services;

import com.project.company.management.domain.entities.Enterprise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de Empresa
 * @author Mfcaicedo
 */
public interface IEnterpriseService {
    /**
     * Listar todas las empresa
     * @return
     */
    public List<Enterprise> findAll();

    /**
     * Encontrar Empresa por id
     *
     * @param id
     * @return
     */
    public Enterprise findById(Long id);

    /**
     * Crear una empresa
     * @param enterprise
     * @return
     */
    public Enterprise create(Enterprise enterprise);

    /**}
     * Actualizar una empresa con id
     * @param id identificador de la empresa a actualizar
     * @param enterprise objeto de empresa a editar
     * @return Empresa con los datos actualizados
     */
    public Enterprise update( Enterprise enterprise);

    /**
     * Eliminar una Empresa con id
     * @param id identificador de la empresa a eliminar
     */
    public void deleteById(Long id);




}
