package com.danielR.danielspring.services;

import java.util.List;
import com.danielR.danielspring.models.Person;

public interface PeopleService {
    List<Person> findAllPeople();
    Person findById(long id);
    Person insert(Person p);
    boolean delete(long id);
    boolean update(Person p);
}