package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.models.User;
import com.danielR.danielspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/check")
    public String checkUser(@RequestBody Map<String, String> json) {
        return this.userService.checkUser(json.get("username"), json.get("password"));
    }

    @PostMapping("/add")
    public String addWord(@RequestBody Map<String, String> json) {
        return this.userService.addUser(json.get("username"), json.get("password"));
    }
}
