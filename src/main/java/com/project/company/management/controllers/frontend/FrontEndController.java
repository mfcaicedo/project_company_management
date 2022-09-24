package com.project.company.management.controllers.frontend;

import com.project.company.management.domain.entities.Employee;
import com.project.company.management.models.Todo;
import com.project.company.management.services.EmployeeImplService;
import com.project.company.management.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FrontEndController {
    @Autowired
    IEmployeeService serviceEmployee;

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("formUser",new Employee());
        return "login";
    }
    @PostMapping("/login")
    public  String postLogin(@ModelAttribute("formUser") Employee employee){
        System.out.println("imprime algo: " + employee); //NOTA AQUPÍ ES QUE NO IMPRIME NADA
        return "redirect:/welcome";
    }
    @GetMapping("/welcome")
    public String getWelcome(Model model){
        model.addAttribute("employees", serviceEmployee.findAll());
        return "welcome";
    }
}
