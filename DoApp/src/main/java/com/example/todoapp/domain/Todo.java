package com.example.todoapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor //Lombok: utilizado para não declara contrutores e getter and setters
@AllArgsConstructor
@Data
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String todoItem;
	
	private String completed;
	
	public Todo() {
		this.todoItem = "";
		this.completed = "";
	}
	
	public Todo (String todoItem, String completed) {
		//super();
		this.setTodoItem(todoItem);
		this.setCompleted(completed);
	}	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTodoItem() {
		return todoItem;
	}

	public void setTodoItem(String todoItem) {
		this.todoItem = todoItem;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}
	
}
