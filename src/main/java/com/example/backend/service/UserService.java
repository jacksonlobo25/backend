package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Person;
import com.example.backend.respository.PersonRepository;

@Service
public class UserService{

    @Autowired
    private PersonRepository userRepository;

    public List<Person> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(Person user) {
        userRepository.save(user);
    }

    public Person getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}