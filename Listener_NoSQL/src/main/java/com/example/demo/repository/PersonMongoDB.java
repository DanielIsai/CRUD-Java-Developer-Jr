package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.example.demo.model.Person;

public interface PersonMongoDB extends MongoRepository<Person,UUID> {

}
