package com.trabalho.kanban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.trabalho.kanban", "com.novo.projeto"}) // Inclua os pacotes necessários
public class KanbanApplication {
	public static void main(String[] args) {
		SpringApplication.run(KanbanApplication.class, args);
	}
}