package com.example.backend.respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.backend.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
}