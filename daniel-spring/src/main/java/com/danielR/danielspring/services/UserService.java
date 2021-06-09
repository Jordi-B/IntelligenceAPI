package com.danielR.danielspring.services;

import com.danielR.danielspring.exceptions.IdNotFoundException;
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

    public User findUserByUserNameAndPassword(String username, String password) {
        return this.repository.findUserByUsernameAndPassword(username, password);
    }
    public  List<User> findAllManagers() {
        return this.repository.findAllByIsManagerTrue();
    }

    public List<User> findAllNonManagers() {
        return this.repository.findAllByIsManagerFalse();
    }

    public String checkUser(String username, String password){
        if(this.repository.findUserByUsername(username) == null){
            return "Username does not exist";
        }
        else if(this.repository.findUserByUsernameAndPassword(username, password) == null){
            return "Password is incorrect";
        }

        return "Correct username and password";
    }

    public String addUser(String username, String password){
        if(this.repository.findUserByUsername(username) != null){
            return "Username already exists";
        }

        User user = new User();
        user.setManager(false);
        user.setPassword(password);
        user.setUsername(username);

        return this.repository.save(user) != null ? "Sign in successfully" : "Something went wrong";
    }

    public String addManager(User user, String username, String password) {
        if(this.repository.findUserByUsername(username) != null){
            return "Username already exists";
        }

        if (!user.isManager()) {
            return "Unauthorized";
        }



        User newUser = new User();
        newUser.setManager(true);
        newUser.setPassword(password);
        newUser.setUsername(username);

        return this.repository.save(newUser) != null ? "Sign in successfully" : "Something went wrong";
    }

    public User getUserById(int id) {
        return this.repository.findById(id).get();
    }

    public String deleteUser(User deleting, String username) throws IdNotFoundException {
        if (deleting.isManager()) {
            this.repository.delete(this.repository.findAllByUsername(username).get(0));
            return "done";
        } else {
            return "Unauthorized";
        }
    }


}
