package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Person;
import com.example.backend.respository.PersonRepository;


@Service
public class PersonService{

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllUsers() {
        List<Person> persons = personRepository.findAll();
        for (Person person : persons) {
            System.out.println(person.getId());
        }
        return persons;
    }

    public void saveUser(Person user) {
        personRepository.save(user);
    }

    public Person getUserById(String id) {
        return personRepository.findById(id).orElse(null);
    }

    public void deleteUserById(String id) {
        personRepository.deleteById(id);
    }
}