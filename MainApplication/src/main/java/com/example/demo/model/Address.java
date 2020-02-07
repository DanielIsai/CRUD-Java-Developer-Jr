package com.example.demo.model;

import java.util.UUID;

public class Address {
	
	private Integer id;
	private UUID uuid;
	private String street;
	private String number;
	private String city;
	private String country;
	private Boolean status;
	
	public Address() {
		
	}
	
	public Address(Integer id, UUID uuid, String street, String number, String city, String country, Boolean status) {
		this.id = id;
		this.uuid = uuid;
		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", uuid=" + uuid + ", street=" + street + ", number=" + number + ", city=" + city
				+ ", country=" + country + ", status=" + status + "]";
	}

}
