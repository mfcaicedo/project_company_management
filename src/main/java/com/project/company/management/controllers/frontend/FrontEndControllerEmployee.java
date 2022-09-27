package com.project.company.management.controllers.frontend;

import com.project.company.management.domain.entities.Employee;
import com.project.company.management.domain.entities.Enum_RoleName;
import com.project.company.management.services.EmployeeImplService;
import com.project.company.management.services.IEmployeeService;
import com.project.company.management.services.IEnterpriseService;
import com.project.company.management.services.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FrontEndControllerEmployee {

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IProfileService profileService;

    @Autowired
    private IEnterpriseService enterpriseService;


    //LISTAR EMPLEADO
    @GetMapping("/employee")
    public String findAll(Model model){
        model.addAttribute("listEmployee", employeeService.findAll());
        return "employee";
    }

    //ELIMINAR EMPLEADO
    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteById(id);
        return "redirect:/employee";
    }

    //AGREGAR EMPLEADO

    @GetMapping("/employee/crear")
    public String formCreate(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("listProfiles",profileService.getProfiles());
        model.addAttribute("roles", Enum_RoleName.values());
        model.addAttribute("listEnterprises", enterpriseService.findAll());
        return "add-employee";
    }

    @PostMapping("/employee")
    public String formSave(@ModelAttribute("employee") Employee employee){
        employeeService.create(employee);
        return "redirect:/employee";
    }



    //EDITAR EMPLEADO
    @GetMapping("/employee/editar/{id}")
    public String formUpdate(@PathVariable Long id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("listProfiles",profileService.getProfiles());
        model.addAttribute("roles", Enum_RoleName.values());
        model.addAttribute("listEnterprises", enterpriseService.findAll());
        return "update-employee";
    }

    @PostMapping("/employee/{id}")
    public String updateEmployee(@PathVariable Long id,@ModelAttribute("employee") Employee employee, Model model){
        Employee employeeExist= employeeService.findById(id);
        employeeExist.setName(employee.getName());
        employeeExist.setEmail(employee.getEmail());
        employeeExist.setPassword(employee.getPassword());
        //employeeExist.setRole(employee.getRole());
        employeeExist.setProfile(employee.getProfile());
        employeeExist.setEnterprise(employee.getEnterprise());
        employeeExist.setUpdatedAt(employee.getUpdatedAt());
        employeeService.update(employeeExist);
        return "redirect:/employee";
    }
}
