package com.example.salecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SalecarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalecarApplication.class, args);
	}

}
