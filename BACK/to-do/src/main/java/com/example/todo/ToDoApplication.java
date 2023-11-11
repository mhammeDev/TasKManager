package com.example.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ToDoApplication {

	public static void main(String[] args){
		SpringApplication.run(ToDoApplication.class, args);
	}

	@GetMapping
	public String testHello(){
		return "Hello World";
	}

}
