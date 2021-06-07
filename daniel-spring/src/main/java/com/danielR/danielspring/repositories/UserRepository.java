package com.danielR.danielspring.repositories;

import com.danielR.danielspring.models.Post;
import com.danielR.danielspring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAll();

}
