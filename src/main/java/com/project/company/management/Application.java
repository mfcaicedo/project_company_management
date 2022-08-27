package com.project.company.management;

import com.project.company.management.domain.Employee;
import com.project.company.management.domain.Enterprise;
import com.project.company.management.domain.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
public class Application {

	/**
	 * Rama de desarrollo (development)
	 * @param args
	 */

	public static void main(String[] args) {
	SpringApplication.run(Application.class, args);

		//Instaciamos los Entidades
		Enterprise objEnterprise = new Enterprise();
		Transaction objTransaction = new Transaction();
		Employee objEmployee = new Employee();

		objEnterprise.setName("Ejemplo");
		System.out.println("name empresa: " + objEnterprise.getName());

	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	return String.format("Hello %s!", name);
	}

}
