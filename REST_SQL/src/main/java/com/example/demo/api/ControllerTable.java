package com.example.demo.api;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Address;
import com.example.demo.service.ServiceTable;
import com.example.demo.util.AddressResponse;

@RestController
public class ControllerTable {
	
	private Logger log = LogManager.getLogger(this);
	
	private final ServiceTable serviceTable;
	
	@Autowired
	public ControllerTable(ServiceTable serviceTable) {
		this.serviceTable = serviceTable;
	}
	
	@PostMapping(value = "/Save")
	public AddressResponse data(@RequestBody Address address) {
		log.info("Save " + address.getUuid());
		return serviceTable.save(address);
	}
	
	@GetMapping(value = "/Address")
	public AddressResponse obtain(@RequestParam("uuid") UUID id) {
		log.info("Obtain Address " + id);
		return serviceTable.findUUIDAddresses(id);
	}
	
	@GetMapping(value = "/Obtain")
	public AddressResponse obtainAddress(@RequestParam("id") Integer id) {
		log.info("Obtain Address " + id);
		return serviceTable.obtainAddress(id);
	}
	
	@GetMapping(value = "/Delete")
	public AddressResponse deleteAddress(@RequestParam("id") Integer id) {
		log.info("Delete Address " + id);
		return serviceTable.deleteAddress(id);
	}
	
	@GetMapping(value = "/DeleteUUID")
	public AddressResponse deleteAddresses(@RequestParam("UUID") UUID id) {
		log.info("Delete Address " + id);
		return serviceTable.deleteAddresses(id);
	}
	
	@GetMapping(value = "/DeleteAll")
	public AddressResponse deleteAllAddresses() {
		log.info("Delete All");
		return serviceTable.deleteAllAddresses();
	}
	
	@GetMapping(value = "/HasAddress")
	public AddressResponse hasAddresses(@RequestParam("UUID") UUID id) {
		return serviceTable.hasAddress(id);
	}

}
