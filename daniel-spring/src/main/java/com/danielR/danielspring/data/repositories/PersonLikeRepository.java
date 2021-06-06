package com.danielR.danielspring.data.repositories;

import com.danielR.danielspring.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonLikeRepository extends CrudRepository<Person, Long> {
}