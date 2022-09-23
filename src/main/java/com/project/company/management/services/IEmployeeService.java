package com.project.company.management.services;

import com.project.company.management.domain.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    /**
     * Listar todas las employee
     * @return
     */
    public List<Employee> findAll();

    /**
     * Encontrar Employee por id
     *
     * @param id
     * @return
     */
    public Employee findById(Long id);

    /**
     * Crear un empleado
     * @param employee
     * @return
     */
    public Employee create(Employee employee);

    /**}
     * Actualizar una employee con id
     * @param id identificador de la empresa a actualizar
     * @param employee objeto de empresa a editar
     * @return Empresa con los datos actualizados
     */
    public Employee update(Long id, Employee employee);

    /**
     * Eliminar una Employee con id
     * @param id identificador de la employee a eliminar
     */
    public void deleteById(Long id);

    /**
     * Encontrar empleado por email
     */
    public Employee getEmployee(String email)throws Exception;

}
