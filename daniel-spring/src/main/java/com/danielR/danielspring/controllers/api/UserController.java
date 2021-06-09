package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.jwt.JwtResponse;
import com.danielR.danielspring.jwt.JwtTokenUtil;
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

    @Autowired
    JwtTokenUtil jwtTokenUtil;

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

    @PostMapping("/check")
    public String checkUser(@RequestBody Map<String, String> json) {
        return this.userService.checkUser(json.get("username"), json.get("password"));
    }

    @PostMapping("/add")
    public String addWord(@RequestBody Map<String, String> json) {
        return this.userService.addUser(json.get("username"), json.get("password"));
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody Map<String, String> json) {
        User user = this.userService.findUserByUserNameAndPassword(json.get("username"), json.get("password"));
        String token = this.jwtTokenUtil.generateToken(user);
        return new JwtResponse(token, user.getUsername(), user.isManager());
    }


    @GetMapping("/me")
    public User getMe(@RequestHeader String token) {
        return this.userService.getUserById(Integer.valueOf(this.jwtTokenUtil.getIdFromToken(token)));
    }

    @DeleteMapping("")
    public int deleteUser(@RequestHeader String token, @RequestBody Map<String, String> json) {
        try {
            this.userService.deleteUser(this.userService.getUserById(
                    Integer.valueOf(this.jwtTokenUtil.getIdFromToken(token))),
                    json.get("username"), json.get("password"));
            return 200;
        } catch (Exception e) {
            return 401;
        }
    }

}
