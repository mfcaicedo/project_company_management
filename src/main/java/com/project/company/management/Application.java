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

<<<<<<< HEAD
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
=======
>>>>>>> development
public class Application {
	/**
	 * Rama de produccion main
	 * @param args
	 */
	public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
	}
<<<<<<< HEAD

=======
>>>>>>> development
}
