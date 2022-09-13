package com.project.company.management.controllers;

import com.project.company.management.domain.entities.Employee;
import com.project.company.management.domain.entities.Enterprise;
import com.project.company.management.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Servicios de la Empresa
 */
@RestController
@RequestMapping("users")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Employee> findAll(){
        return (List<Employee>) employeeService.findAll();
    }

    /**
     * Método para crear un empleado
     * @param employee objeto con los atributos de empleado
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    /**
     * Método para actualizar un empleado
     * @param employee objeto de empleado a actualizar
     * @param id identificador del empleado a editar
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH, produces= "application/json")
    @ResponseBody
    public Employee update(@RequestBody Employee employee, @PathVariable Long id) {
        return employeeService.update(id, employee);
    }
    /**
     * Método para eliminar un empleado
     * @param id indentificador del empleado a eliminar
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        employeeService.deleteById(id);
    }

}
