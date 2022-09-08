package com.project.company.management;

import com.project.company.management.domain.entities.Employee;
import com.project.company.management.domain.entities.Enterprise;
import com.project.company.management.domain.entities.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@SpringBootApplication

public class Application {

	/**
	 * Rama de produccion main
	 * @param args
	 */

	public static void main(String[] args) {
	SpringApplication.run(Application.class, args);

	Date prueba = new Date();
	System.out.println("fecha: " + prueba);


		//Instaciamos los Entidades
		//Enterprise objEnterprise = new Enterprise();
		//Transaction objTransaction = new Transaction();
		//Employee objEmployee = new Employee();

		//objEnterprise.setName("Ejemplo");
		//System.out.println("name empresa: " + objEnterprise.getName());
	}
	
	//@GetMapping("/hello")
	//public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	//return String.format("Hello %s!", name);
	}

//}
