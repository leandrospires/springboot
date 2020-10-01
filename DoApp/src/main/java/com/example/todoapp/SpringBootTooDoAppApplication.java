package com.example.todoapp;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.todoapp.domain.Todo;
import com.example.todoapp.repository.TodoRepository;

@SpringBootApplication
public class SpringBootTooDoAppApplication implements CommandLineRunner {

	@Autowired
	public TodoRepository todoRepository;	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTooDoAppApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		Collection<Todo> todos = Arrays.asList(new Todo("Pausa para o café", "Yes"), new Todo("Dormir", "No"), new Todo("Tomar banho", "Yes"), new Todo("Fritar Pastel", "Yes"));
		todos.forEach(todoRepository::save);
	
	}
}
