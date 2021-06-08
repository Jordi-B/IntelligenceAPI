package com.danielR.danielspring.services;

import com.danielR.danielspring.models.User;
import com.danielR.danielspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAllUsers() {
        return this.repository.findAll();
    }

//    public  List<User> findAllManagers() {
//        return this.repository.findAllByIsManagerTrue();
//    }
}
