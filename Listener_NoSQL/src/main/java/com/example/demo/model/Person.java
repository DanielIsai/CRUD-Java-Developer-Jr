package com.example.demo.model;


import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "People")
public class Person {
	
	@Id
	private UUID id;
	private String name;
	private String email;
	private String phone;
	private Boolean status;

	public Person() {
		
	}

	public Person(UUID id, String name, String email, String phone, Boolean status) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.status = status;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", status=" + status
				+ "]";
	}	
	
}
