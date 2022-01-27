package com.truckingApp.Trucking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "repositories-package")
//@EntityScan(basePackages = "entities-package")
public class TruckingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruckingApplication.class, args);
	}

}
