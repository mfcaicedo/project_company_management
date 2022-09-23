package com.project.company.management.controllers.frontend;

import com.project.company.management.domain.entities.Employee;
import com.project.company.management.domain.entities.Enum_RoleName;
import com.project.company.management.services.EmployeeImplService;
import com.project.company.management.services.IEmployeeService;
import com.project.company.management.services.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FrontEndControllerEmployee {

    @Autowired
    IEmployeeService employeeImplService;

    @Autowired
    IProfileService profileService;


    @DeleteMapping("/delete/employee/front/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeImplService.deleteById(id);
        return "redirect:/welcome";
    }

    @GetMapping("employee/add")
    public String getAddEmployee(Model model){
        model.addAttribute("newEmployee", new Employee());
        model.addAttribute("perfiles", profileService);
        model.addAttribute("roles", Enum_RoleName.values());
        return "add-employee";
    }

    @PostMapping("/employee/front")
    public String postEmployee(@ModelAttribute("newUser") Employee employee){
        employeeImplService.create(employee);

        return "Redirect:/welcome";
    }
    @GetMapping("/usuario/update/front/{id}")
    public String getEmployee(Model model, @PathVariable String id) throws Exception{
        employeeImplService.getEmployee(id) ;
        try{
            model.addAttribute("UpdateEmployee", employeeImplService.getEmployee(id));
            return "update-user";
        }catch (Exception e){
            return "/error";
        }
    }

    @PatchMapping("/usuario/front/{id}")
    public String patchEmployee(@ModelAttribute("newUser") Employee employee){

        return "";
    }
}
