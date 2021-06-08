package com.danielR.danielspring.services;

import com.danielR.danielspring.models.License;
import com.danielR.danielspring.repositories.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseService {
    @Autowired
    private LicenseRepository repository;

    public List<License> findAllLicenses() {
        return this.repository.findAll();
    }

    public List<License> getAllByPersonId(String id) {
        return this.repository.findAllByPersonId_Id(id);
    }
}
