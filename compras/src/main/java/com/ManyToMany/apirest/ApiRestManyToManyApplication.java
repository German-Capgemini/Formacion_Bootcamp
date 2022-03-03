package com.ManyToMany.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="API Compras",version="1.0",description="Crud de API Compras"))
public class ApiRestManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestManyToManyApplication.class, args);
	}

}
