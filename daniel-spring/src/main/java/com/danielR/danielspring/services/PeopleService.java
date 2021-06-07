package com.danielR.danielspring.services;

import java.util.List;
import java.util.Optional;

import com.danielR.danielspring.data.repositories.PersonLikeRepository;
import com.danielR.danielspring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface PeopleService {
    List<Person> findAllPeople();
    Person findById(long id);
    Person insert(Person p);
    boolean delete(long id);
    boolean update(Person p);

    @Service
    class PeopleServiceImp implements PeopleService{
        @Autowired
        private PersonLikeRepository repository;

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
}