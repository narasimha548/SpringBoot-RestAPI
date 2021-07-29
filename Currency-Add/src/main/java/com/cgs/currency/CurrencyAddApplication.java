package com.cgs.currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
public class CurrencyAddApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyAddApplication.class, args);
	}

}
