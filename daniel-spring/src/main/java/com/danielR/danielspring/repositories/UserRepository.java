package com.danielR.danielspring.repositories;

import com.danielR.danielspring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    List<User> findAllByIsManagerTrue();
    List<User> findAllByIsManagerFalse();
    User findUserByUsernameAndPassword(String username, String password);
    User findUserByUsername(String username);
}
