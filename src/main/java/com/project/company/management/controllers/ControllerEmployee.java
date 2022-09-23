package com.project.company.management.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.company.management.domain.entities.Employee;
import com.project.company.management.domain.entities.Enum_RoleName;
import com.project.company.management.domain.entities.Transaction;
import com.project.company.management.services.IEnterpriseService;
import com.project.company.management.services.IServiceEmployee;
import com.project.company.management.services.IServiceProfile;
import com.project.company.management.services.IServiceTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ControllerEmployee {

    @Autowired
    private IServiceEmployee employeeService;

    @Autowired
    private IServiceProfile profileService;

    @Autowired
    private IEnterpriseService enterpriseService;


    //OBTENER TODOS LOS EMPLEADOS
    /*
    @GetMapping("/users")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
     */
    @GetMapping("/users")
    public String findAll(Model model){
        model.addAttribute("employees", employeeService.findAll());
        return "users";
    }

    //CREAR EMPLEADO
    //@PostMapping(value = "/users",produces = "application/json")
    /*
    @PostMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }
     */
    @GetMapping("/users/crear")
    public String formCreate(Model model){
        Employee employee = new Employee();

        model.addAttribute("employee", employee);
        model.addAttribute("profiles",profileService.findAll());
        model.addAttribute("roles", Enum_RoleName.values());
        model.addAttribute("enterprises", enterpriseService.findAll());
        return "post_employee";
    }

    @PostMapping("/users")
    public String formSave(@ModelAttribute("employee") Employee employee){
        employeeService.create(employee);
        return "redirect:/users/";
    }

    //OBTENER EMPLEADO ESPECIFICO
    /*
    @GetMapping(path = "users/{id}")
    public Employee findById(@PathVariable("id") Long id){
        return employeeService.findById(id);
    }

     */

    //EDITAR O ACTUALIZAR EMPLEADO ESPECIFICO
    /*
    @PatchMapping("/users/{id}")
    public Employee update(@PathVariable("id") Long id, @RequestBody Employee employee){
        return employeeService.update(id,employee);
    }

     */
    @GetMapping("/users/editar/{id}")
    public String formUpdate(@PathVariable Long id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("profiles",profileService.findAll());
        model.addAttribute("roles", Enum_RoleName.values());
        model.addAttribute("enterprises", enterpriseService.findAll());
        return "patch_employee";
    }

    @PostMapping("/users/{id}")
    public String updateEmployee(@PathVariable Long id,@ModelAttribute("employee") Employee employee, Model model){
        Employee employeeExist= employeeService.findById(id);
        employeeExist.setName(employee.getName());
        employeeExist.setEmail(employee.getEmail());
        //employeeExist.setRole(employee.getRole());
        employeeExist.setProfile(employee.getProfile());
        employeeExist.setEnterprise(employee.getEnterprise());
        employeeExist.setUpdatedAt(employee.getUpdatedAt());
        employeeService.update(employeeExist);
        return "redirect:/users";
    }

    //ELIMINAR EMPLEADO ESPECIFICO
    /*
    @DeleteMapping("/users/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return employeeService.deleteById(id);
    }
     */
    @GetMapping("/users/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteById(id);
        return "redirect:/users";
    }





}
