package com.spring.formulariologin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.spring.formulariologin") // Reemplaza con tu paquete base
public class FormulariologinApplication {
	public static void main(String[] args) {
		SpringApplication.run(FormulariologinApplication.class, args);
	}
}

