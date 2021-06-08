package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.models.User;
import com.danielR.danielspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()

@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return this.userService.findAllUsers();
    }

    @GetMapping("/managers")
    public List<User> getManagers() {
        return this.userService.findAllManagers();
    }

    @GetMapping("/managers/false")
    public List<User> getNonManagers() {
        return this.userService.findAllNonManagers();
    }

}
