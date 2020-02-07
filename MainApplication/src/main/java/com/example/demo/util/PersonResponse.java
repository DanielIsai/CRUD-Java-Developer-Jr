package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.demo.model.Person;


@Component
public class PersonResponse {
	
	private String request;
	private String code;
	private String message;	
	private UUID id;
	private Person personResult;
	private List<Person> listResult;
	
	private void clearPersonResponse() {
		this.request = null;
		this.code = null;
		this.message = null;
		this.id = null;
		this.personResult = null;
		this.listResult = null;
	}
	
	public void setPerson(String request, String code, String message, Person personResult) {
		clearPersonResponse();
		this.request = request;
		this.code = code;
		this.message = message;
		this.personResult = personResult;
	}
	
	public void setToList(String request, String code, String message, Person personResult) {
		clearPersonResponse();
		List<Person> newlist = new ArrayList<Person>();
		newlist.add(personResult);
		this.request = request;
		this.code = code;
		this.message = message;
		this.listResult = newlist;
	}
	
	
	public void setPersonList(String request, String code, String message, List<Person> listResult) {
		clearPersonResponse();
		this.request = request;
		this.code = code;
		this.message = message;
		this.listResult = listResult;
	}
	
	public void setId(String request, String code, String message, UUID id) {
		clearPersonResponse();
		this.request = request;
		this.code = code;
		this.message = message;
		this.id = id;
	}
	
	public void setMessage(String request, String code, String message) {
		clearPersonResponse();
		this.request = request;
		this.code = code;
		this.message = message;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Person getPersonResult() {
		return personResult;
	}

	public void setPersonResult(Person personResult) {
		this.personResult = personResult;
	}

	public List<Person> getListResult() {
		return listResult;
	}

	public void setListResult(List<Person> listResult) {
		this.listResult = listResult;
	}
}
