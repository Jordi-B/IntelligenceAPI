package com.danielR.danielspring.services;

import com.danielR.danielspring.models.Person;
import com.danielR.danielspring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public List<Person> findAllPersons() {
        return this.repository.findAll();
    }
}
