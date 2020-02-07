package com.example.demo.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.example.demo.model.Address;

@Component
public class ServiceFunctions {
	
	public List<Address> findAllUUID(UUID id, List<Address> listAddress) {
		List<Address> addressList = listAddress.stream()
										.filter(a -> a.getUuid().equals(id))
										.filter(a -> a.getStatus())
										.collect(Collectors.toList());
		return addressList;
	}
	
	
	public List<Address> visibleList(List<Address> listAddress){
		return listAddress.stream()
				.filter(p -> p.getStatus())
				.collect(Collectors.toList());
	}
	
	public Address visiblePerson(Address address){
		if(address.getStatus()) return address;
		else return null;
	}


}
