package com.danielR.danielspring.services;

import com.danielR.danielspring.models.License;
import com.danielR.danielspring.repositories.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private LicenseRepository repository;

    public List<License> findAllUsers() {
        return this.repository.findAll();
    }
}
