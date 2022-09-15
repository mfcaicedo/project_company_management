package com.project.company.management.services;

import com.project.company.management.domain.entities.Enterprise;
import com.project.company.management.repositories.IRepositoryEnterprise;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de la Empresa
 * @author Mfcaicedo
 */
@Service
public class EnterpriseImplService implements IEnterpriseService{

    /**
     * Inyeccion de Empresa
     * @return
     */
    //INYECTAR DEPENDENCIAS
    @Autowired
    private IRepositoryEnterprise enterpriseDao;

    /**
     * Servicio para listar todas las empresas
     * @return lista de las empresas guardadas en la DB
     */
    @Override
    //@Transactional(readOnly=true) // Sincronización con la DB
    public List<Enterprise> findAll() {
        return (List<Enterprise>) enterpriseDao.findAll();
    }

    @Override
    public Enterprise findById(Long id) {
        Enterprise enterprise1 = enterpriseDao.findById(id).orElse(null);
        return enterprise1;
    }

    /**
     * Crear una empresa
     * @param enterprise
     * @return
     */
    @Override
    public Enterprise create(Enterprise enterprise) {
        return enterpriseDao.save(enterprise);
    }

    /**
     * Actualización de una empresa
     * @param id identificador de la empresa a actualizar
     * @param enterprise objeto de empresa a editar
     * @return
     */
    @Override
    //ME PERMITE SINCRONIZAR LA BASE DE DATOS
    //@Transactional
    public Enterprise update(Long id, Enterprise enterprise) {
        Enterprise enterprise1 = this.findById(id);
        enterprise1.setName(enterprise.getName());
        enterprise1.setDocument(enterprise.getDocument());
        enterprise1.setAddress(enterprise.getAddress());
        enterprise1.setUpdateAt(enterprise.getUpdateAt());
        enterprise1.setPhone(enterprise.getPhone());
        return enterpriseDao.save(enterprise1);
    }
    /**
     * Eliminar una empresa con id
     * @param id identificador de la empresa a eliminar
     */
    @Override
    //@Transactional
    public void deleteById(Long id) {
        enterpriseDao.deleteById(id);
    }

}
