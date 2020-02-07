package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonMongoDB;
import com.example.demo.util.MessageResponse;
import com.example.demo.util.PersonResponse;
import com.example.demo.util.AddressResponse;

@Service
public class PersonService {

	private String URIservice = "http://localhost:8090";
	private Logger log = LogManager.getLogger(this);
	
	private final PersonMongoDB peopleRepository;
	private final MessageResponse msg;
	private final PersonResponse personResponse;
	private final ServiceFunctions sFunction;
	
	@Autowired						
	public PersonService(PersonMongoDB peopleRepository, MessageResponse msg, PersonResponse personResponse, ServiceFunctions serviceFuctions) {
		this.sFunction = serviceFuctions;
		this.peopleRepository = peopleRepository;
		this.msg = msg;
		this.personResponse = personResponse;
	}
	
	public PersonResponse save(Person person) {
		person.setId(UUID.randomUUID());
		personResponse.setPerson("save",msg.codeSuccess(), msg.Success(), person);
		sFunction.sendKafka(personResponse);
        return personResponse;
	}
	
	public PersonResponse update(Person person) {
		personResponse.setPerson("update", msg.codeSuccess(), msg.Success(), person);
		sFunction.sendKafka(personResponse);
		return personResponse;
	}

	public PersonResponse delete(UUID id) {
		personResponse.setId("delete", msg.codeSuccess(), msg.Success(), id);
		sFunction.sendKafka(personResponse);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URIservice + "/DeleteUUID").queryParam("UUID", id);
		sFunction.getREST(builder).getBody();
		return personResponse;
	}

	public PersonResponse deleteAll() {
		personResponse.setMessage("deleteAll", msg.codeSuccess(), msg.Success());
		sFunction.sendKafka(personResponse);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URIservice+"/DeleteAll");
		sFunction.getREST(builder);
        return personResponse;
	}
	
	public PersonResponse findAll(){
		personResponse.setPersonList("findAll", msg.codeSuccess(), msg.Success(), sFunction.visibleList(peopleRepository.findAll()));
		return personResponse;
	}
	
	public PersonResponse findById(UUID id){
		List<Person> personCollection = new ArrayList<Person>();
		personCollection.add(sFunction.visiblePerson(peopleRepository.findById(id).orElse(null)));
		return sFunction.putPersonResponse(personCollection, "findbyId");		
	}
	
	public PersonResponse findByName(String name){
		List<Person> personCollection = sFunction.findNameList(sFunction.visibleList(peopleRepository.findAll()), name);		
		return sFunction.putPersonResponse(personCollection, "findbyName");			
	}
	
	public PersonResponse advancedSearch(String cname, String cemail, String cphone) {
		List<Person> personCollection = sFunction.advancedSearch( sFunction.visibleList(peopleRepository.findAll()), cname, cemail, cphone);	
		return sFunction.putPersonResponse(personCollection, "advancedSearch");	
	}
	
	public AddressResponse saveAddress(Address address) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URIservice + "/Save");
 		log.info("Save Address " + address);
        return sFunction.postREST(address,builder).getBody();
	}

	public AddressResponse findUUIDAddresses(UUID uuid){
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URIservice + "/Address").queryParam("uuid", uuid);
 		log.info("Find Addresses of " + uuid);
 		return sFunction.getREST(builder).getBody();
	}
	
	public AddressResponse obtainAddress(Integer id) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URIservice + "/Obtain").queryParam("id", id);
 		log.info("Obtain the Address " + id);
		return sFunction.getREST(builder).getBody();
	}
	
	public AddressResponse deleteAddress(Integer id) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URIservice + "/Delete").queryParam("id", id);
 		log.info("Delete Address " + id);
		return sFunction.getREST(builder).getBody();
	}

	public AddressResponse hasAddress(UUID id) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URIservice + "/HasAddress").queryParam("UUID", id);
		return sFunction.getREST(builder).getBody();
	}
	
}
