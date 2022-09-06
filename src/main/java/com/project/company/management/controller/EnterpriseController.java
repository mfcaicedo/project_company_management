package com.project.company.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnterpriseController {

    @GetMapping("/Enterprise")
    public String EnterpriseList(){
        return "Lista de empresas";
    }
}
