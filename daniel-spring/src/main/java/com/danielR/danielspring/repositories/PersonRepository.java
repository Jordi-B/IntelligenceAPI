package com.danielR.danielspring.repositories;

import com.danielR.danielspring.models.Person;
import com.danielR.danielspring.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    List<Person> findAll();

}
