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
public class Application {

	/**
	 * Rama de desarrollo (development)
	 * @param args
	 */

	public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
	}

}
