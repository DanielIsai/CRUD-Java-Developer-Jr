package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.util.AddressResponse;
import com.example.demo.util.MessageResponse;

@Service
public class ServiceTable {
	
	private Integer MaxAddress = 5;

	private AddressRepository addressRepository;
	private ServiceFunctions function;
	private AddressResponse addressResponse;
	private MessageResponse msg;
	
	@Autowired						
	public ServiceTable(AddressRepository addressRepository, ServiceFunctions function, AddressResponse addressResponse, MessageResponse msg) {
		this.addressRepository = addressRepository;
		this.function = function;
		this.addressResponse = addressResponse;
		this.msg = msg;
	}
	
	public AddressResponse save(Address address) {
		
		if(findUUIDAddresses(address.getUuid()).getAddressList().stream().count() < MaxAddress) {
			addressRepository.save(address);
			addressResponse.setMessage(msg.codeSuccess(), msg.Success());
		}
		else {
			addressResponse.setMessage(msg.codeError(), msg.Full());
		}
		return addressResponse;
	}

	public AddressResponse findUUIDAddresses(UUID id) {
		addressResponse.setAddressList(msg.codeSuccess(), msg.Success(), function.findAllUUID(id, addressRepository.findAll()));
		return addressResponse;
	}

	public AddressResponse obtainAddress(Integer id) {
		addressResponse.setAddress(msg.codeSuccess(), msg.Success(), function.visiblePerson(addressRepository.findById(id).get()));
		return addressResponse;
	}

	public AddressResponse deleteAddress(Integer id) {
		Address newAddress = addressRepository.findById(id).get();
		newAddress.setStatus(false);
		addressRepository.save(newAddress);		
		addressResponse.setMessage(msg.codeSuccess(), msg.Success());
		return addressResponse;
	}

	public AddressResponse deleteAllAddresses() {
		addressRepository.deleteAll();
		addressResponse.setMessage(msg.codeSuccess(), msg.Success());
		return addressResponse;
	}

	public AddressResponse deleteAddresses(UUID id) {
		List<Address> deleteAddress = function.findAllUUID(id, addressRepository.findAll());
		/*for(int i = 0; i < deleteAddress.size(); i++) {
			deleteAddress.get(i).setStatus(false);
			addressRepository.save(deleteAddress.get(i));
		}
		*/
		deleteAddress.stream().forEach(a ->{ a.setStatus(false); addressRepository.save(a); });
		addressResponse.setMessage(msg.codeSuccess(), msg.Success());
		return addressResponse;
	}

	public AddressResponse hasAddress(UUID id) {
		addressResponse.setMessage(msg.codeSuccess(), "This Person has " + function.findAllUUID(id, addressRepository.findAll()).size() + " addresses" );
		return addressResponse;
	}

}
