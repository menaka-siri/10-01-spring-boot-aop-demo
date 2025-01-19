package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {
		return runner -> {
			System.out.println("Hi, Mom!");

			// call the business method
			demoTheBeforeAdvice(theAccountDAO);

			System.out.println("\n let's call it again");

			// call the business method again
			demoTheBeforeAdvice(theAccountDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {
		// call the business method
		theAccountDAO.addAccount();
	}

}
