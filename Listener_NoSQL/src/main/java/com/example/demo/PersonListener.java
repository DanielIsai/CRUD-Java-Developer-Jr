package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.example.demo.kafka.PersonKafkaStreams;
import com.example.demo.model.Person;
import com.example.demo.model.PersonResponse;
import com.example.demo.repository.PersonMongoDB;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonListener {
	
	private final Logger log = LogManager.getLogger(this);
	
	private final PersonMongoDB peopleRepository;
	
	@Autowired						
	public PersonListener(PersonMongoDB peopleRepository) {
		this.peopleRepository = peopleRepository;
	}
	
	

    @StreamListener(PersonKafkaStreams.INPUT)
    public void handlePerson(@Payload PersonResponse personResponse) {
    	
    
    	
    
    	Person person = personResponse.getPersonResult();
    	
    	
    	if(personResponse.getRequest().equals("save")) {
    		peopleRepository.save(person);
    		log.info(person.getName()+" saved");
    	}
    	
    	if(personResponse.getRequest().equals("update")) {
    		if(!ObjectUtils.isEmpty(peopleRepository.findById(person.getId()))) {
        		peopleRepository.save(person);
        		log.info(person.getId()+" updated");
    		}
    		else {
    			log.info(person.getId()+" does not exist");
    		}
    	}
    	
    	if(personResponse.getRequest().equals("delete")) {
    		if(peopleRepository.findById(personResponse.getId()).orElse(null).getStatus()){
    			Person newPerson = peopleRepository.findById(personResponse.getId()).orElse(null);
    			newPerson.setStatus(false);
    			peopleRepository.save(newPerson);
    			log.info(personResponse.getId()+" deleted");
    		}
    		else {
    			log.info(personResponse.getId()+" does not exist");
    		}
    	}
    	
    	
    	
    	if(personResponse.getRequest().equals("deleteAll")) {
    		peopleRepository.deleteAll();
    		log.info("All deleted");
    	}
    	
    }
}

