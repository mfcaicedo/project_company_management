package com.project.company.management.controllers;

import com.project.company.management.domain.entities.Enterprise;
import com.project.company.management.services.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Servicios de la Empresa
 */
@RestController
@RequestMapping("enterprises")
public class EnterpriseController {
    @Autowired
    private IEnterpriseService enterpriseService;
    /**
     *  Obtener todas las empresas
     * @return lista de empresas
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Enterprise> findAll(){

        return (List<Enterprise>) enterpriseService.findAll();
    }

    /**
     *  Obtener una empresa por id
     * @param id identificador de la empresa a buscar
     * @return empresa encontrada
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Enterprise  findById(@PathVariable Long id){
        Enterprise enterprise = enterpriseService.findById(id);
        return enterprise;
    }

    /**
     * Método para crear una empresa
     * @param enterprise objeto con los atributos de empresa
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Enterprise create(@RequestBody Enterprise enterprise){
        return enterpriseService.create(enterprise);
    }

    /**
     * Método para actualizar una empresa
     * @param enterprise objeto de empresa a actualizar
     * @param id identificador de la empresa a editar
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH, produces= "application/json")
    @ResponseBody
    public Enterprise update(@RequestBody Enterprise enterprise, @PathVariable Long id) {
        return enterpriseService.update(id, enterprise);
    }
    /**
     * Método para eliminar una empresa
     * @param id indentificador de la empresa a eliminar
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        enterpriseService.deleteById(id);
    }

}
