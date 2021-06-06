package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.models.User;
import com.danielR.danielspring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()

@RequestMapping("/api/users")

public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("")
    public List<User> getAllPeople() {
        return new ArrayList<User>();
    }

}
