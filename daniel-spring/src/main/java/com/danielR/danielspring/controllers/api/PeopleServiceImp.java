package com.danielR.danielspring.controllers.api;

import java.util.List;
import java.util.Optional;

import com.danielR.danielspring.data.repositories.PersonRepository;
import com.danielR.danielspring.models.Person;
import com.danielR.danielspring.services.PeopleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImp implements PeopleService{
    @Autowired
    private PersonRepository repository;

    @Override
    public List<Person> findAllPeople() {
        return (List<Person>)repository.findAll();
    }

    @Override
    public Person insert(Person p) {
        return repository.save(p);
    }

    @Override
    public boolean delete(long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Person findById(long id) {
        Optional<Person> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean update(Person p) {
        try {
            repository.save(p);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
