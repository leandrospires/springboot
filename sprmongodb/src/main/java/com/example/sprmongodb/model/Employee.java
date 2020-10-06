package com.example.sprmongodb.model;

import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee")
public class Employee {

	@Transient //criar a sequência que não será persistida em BD
	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private long id;

	@NotBlank
	@Size(max = 100)
	@Indexed(unique = true)
	private String firstName;
	private String lastName;

	@NotBlank
	@Size(max = 100)
	@Indexed(unique = true)
	private String emailId;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String emailId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ",	lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}

}
