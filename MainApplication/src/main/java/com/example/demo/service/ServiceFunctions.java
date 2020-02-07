package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.kafka.PersonKafkaStreams;
import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.util.AddressResponse;
import com.example.demo.util.MessageResponse;
import com.example.demo.util.PersonResponse;

@Component
public class ServiceFunctions {
	
	private HttpHeaders headers = new HttpHeaders();
	private HttpEntity<?> entity = new HttpEntity<>(headers);
	private HttpEntity<AddressResponse> response = new HttpEntity<>(headers);
	private AddressResponse addressResponse = new AddressResponse();
	
	
	private final PersonKafkaStreams personKafkaStreams;
	private final PersonResponse personResponse;
	private final MessageResponse m;
	private final RestTemplate restTemplate;
	
	@Autowired
	public ServiceFunctions(PersonKafkaStreams personKafkaStreams, MessageResponse messageResponse, PersonResponse personResponse, RestTemplate restTemplate) {
		this.personKafkaStreams = personKafkaStreams;
		this.personResponse = personResponse;
		this.m = messageResponse;
		this.restTemplate = restTemplate;
	}
	
	public PersonResponse putPersonResponse(List<Person> personCollection, String message) {
		if(!personCollection.isEmpty()) {personResponse.setPersonList(message, m.codeSuccess(), m.GetList(), personCollection);}
		else {personResponse.setPersonList(message, m.codeError(), m.NotExist(), personCollection);}
		return personResponse;
	}
	
	public void sendKafka(PersonResponse personResponse) {
		MessageChannel messageChannel = personKafkaStreams.outboundGreetings();
		messageChannel.send(MessageBuilder.withPayload(personResponse).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
	}
	
	public List<Person> findNameList(List<Person> peopleList, String name){
		return searchName(peopleList, p -> p.getName().contains(name));
	}

	public List<Person> advancedSearch(List<Person> peopleList, String name, String email, String phone) {
		return peopleList.stream()
				.filter(!name.equals("")?  p -> p.getName().contains(name)   : p -> true)
				.filter(!email.equals("")? p -> p.getEmail().contains(email) : p -> true)
				.filter(!phone.equals("")? p -> p.getPhone().contains(phone) : p -> true)
				.collect(Collectors.toList());
	}
	
	public static List<Person> searchName(List<Person> people, Predicate<Person> predicate) {
		List<Person> listObtained = new ArrayList<Person>();
		for(Person p: people) 
			if(predicate.test(p)) 
				listObtained.add(p);
		return listObtained;
	}
	
	
	
	public HttpEntity<AddressResponse> getREST(UriComponentsBuilder builder){
		
 		try {
 			response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, AddressResponse.class);
 			}
 			catch(Exception e) {
 				addressResponse.setMessage(m.codeError(), m.NotConnection());
 				response = new HttpEntity<>(addressResponse);
 			}
 		
 		return response;
		
	}
	
	
	
	public HttpEntity<AddressResponse> postREST(Address address, UriComponentsBuilder builder){
		HttpEntity<Address> request= new HttpEntity<Address>(address);
			
			try {
				response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, request, AddressResponse.class);
				}
				catch(Exception e) {
					addressResponse.setMessage(m.codeError(), m.NotConnection());
					response = new HttpEntity<>(addressResponse);
				}
 		
 		return response;
		
	}
	
	
	public List<Person> visibleList(List<Person> listPeople){
		return listPeople.stream()
				.filter(p -> p.getStatus())
				.collect(Collectors.toList());
	}
	
	public Person visiblePerson(Person person){
		if(person.getStatus()) return person;
		else return null;
	}
		
	
	
	
	
	
}
