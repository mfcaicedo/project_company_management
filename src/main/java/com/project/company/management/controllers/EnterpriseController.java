package com.project.company.management.controllers;

import com.project.company.management.domain.entities.Enterprise;
import com.project.company.management.services.IEnterpriseService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Servicios de la Empresa
 */
//@RestController
@Controller
//@RequestMapping("/enterprises/")
public class EnterpriseController {
    @Autowired
    private IEnterpriseService enterpriseService;
    //@RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @GetMapping("/enterprises")
    //@ResponseBody
    /*
    public List<Enterprise> findAll(){
        return (List<Enterprise>) enterpriseService.findAll();
    }

     */
    //Model es un soporte para un modelo y una vista;
    //permite devolver tanto el modelo como la vista en un valor devuelto.
    //En sistemas embebidos es decir FrontEnd y Backend dependen de un mismo servidor
    //Siempre se tratará con la peticion GET

    public String findAll(Model model){
        model.addAttribute("enterprises", enterpriseService.findAll());
        return "enterprises"; //Retorna el archivo HTML
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
     * @param model objeto con los atributos de empresa
     * @return
     */
    /*
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody

    public Enterprise create(@RequestBody Enterprise enterprise){
        return enterpriseService.create(enterprise);
    }
    */

    @GetMapping("/enterprises/crear")
    public String formCreate(Model model){
        Enterprise enterprise = new Enterprise();
        model.addAttribute("enterprise", enterprise);
        return "post_enterprise";
    }

    @PostMapping("/enterprises")
    public String formSave(@ModelAttribute("enterprise") Enterprise enterprise){
        enterpriseService.create(enterprise);
        return "redirect:/enterprises/";
    }

    /**
     * Método para actualizar una empresa
     * @param model objeto de Model para formularioS
     * @param id identificador de la empresa a editar
     * @return
     */
    /*
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH, produces= "application/json")
    @ResponseBody
    public Enterprise update(@RequestBody Enterprise enterprise, @PathVariable Long id) {
        return enterpriseService.update(id, enterprise);
    }
    */

    @GetMapping("enterprises/editar/{id}")
    public String formUpdate(@PathVariable Long id, Model model){
        model.addAttribute("enterprise",enterpriseService.findById(id));
        return "patch_enterprise";
    }

    @PostMapping("/enterprises/{id}")
    public String updateEnterprise(@PathVariable Long id, @ModelAttribute("enterprise") Enterprise enterprise, Model model){
        Enterprise enterpriseExist = enterpriseService.findById(id);
        enterpriseExist.setName(enterprise.getName());
        enterpriseExist.setDocument(enterprise.getDocument());
        enterpriseExist.setAddress(enterprise.getAddress());
        enterpriseExist.setUpdateAt(enterprise.getUpdateAt());
        enterpriseExist.setPhone(enterprise.getPhone());
        enterpriseService.update(enterpriseExist);
        return "redirect:/enterprises";
    }


    /**
     * Método para eliminar una empresa
     * @param id indentificador de la empresa a eliminar
     */
    /*
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        enterpriseService.deleteById(id);
    }
    */

    @GetMapping("/enterprises/{id}")
    public String deleteEnterprise(@PathVariable Long id){
        enterpriseService.deleteById(id);
        return "redirect:/enterprises";
    }

}
