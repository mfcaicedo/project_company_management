package com.project.company.management.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.company.management.domain.entities.Employee;
import com.project.company.management.services.IServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class ControllerEmployee {

    @Autowired
    private IServiceEmployee employeeService;

    //OBTENER TODOS LOS EMPLEADOS
    @GetMapping("/users")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    //CREAR EMPLEADO
    //@PostMapping(value = "/users",produces = "application/json")
    @PostMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    //OBTENER EMPLEADO ESPECIFICO
    @GetMapping(path = "users/{id}")
    public Employee findById(@PathVariable("id") Long id){
        return employeeService.findById(id);
    }

    //EDITAR O ACTUALIZAR EMPLEADO ESPECIFICO
    @PatchMapping("/users/{id}")
    public Employee update(@PathVariable("id") Long id, @RequestBody Employee employee){
        return employeeService.update(id,employee);
    }

    //ELIMINAR EMPLEADO ESPECIFICO
    @DeleteMapping("/users/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return employeeService.deleteById(id);
    }


}
