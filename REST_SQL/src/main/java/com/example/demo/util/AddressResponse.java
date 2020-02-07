package com.example.demo.util;

import org.springframework.stereotype.Component;
import java.util.List;
import com.example.demo.model.Address;

@Component
public class AddressResponse {
	
	private String code;
	private String message;
	private Address address;
	private List<Address> addressList;
	
	public AddressResponse() {
		
	}
		
	public void setAddressResponse(String code, String message, Address address, List<Address> addressList) {
		clearAddressResponse();
		this.code = code;
		this.message = message;
		this.address = address;
		this.addressList = addressList;
	}
	
	public void setMessage(String code, String message) {
		clearAddressResponse();
		this.code = code;
		this.message = message;
	}
	
	public void setAddress(String code, String message, Address address) {
		clearAddressResponse();
		this.code = code;
		this.message = message;
		this.address = address;
	}
	
	public void setAddressList(String code, String message, List<Address> addressList) {
		clearAddressResponse();
		this.code = code;
		this.message = message;
		this.addressList = addressList;
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
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Address> getAddressList() {
		return addressList;
	}
	
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	
	private void clearAddressResponse() {
		this.code = null;
		this.message = null;
		this.address = null;
		this.addressList = null;
	}

	@Override
	public String toString() {
		return "AddressResponse [code=" + code + ", message=" + message + ", address=" + address + ", addresList="
				+ addressList + "]";
	}	
	
}
