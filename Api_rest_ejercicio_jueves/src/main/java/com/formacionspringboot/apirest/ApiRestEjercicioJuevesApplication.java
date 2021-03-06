package com.formacionspringboot.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="API Empleados",version="1.0",description="Crud completo de empleados"))
public class ApiRestEjercicioJuevesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestEjercicioJuevesApplication.class, args);
	}

}
