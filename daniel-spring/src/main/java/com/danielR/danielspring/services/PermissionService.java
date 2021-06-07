package com.danielR.danielspring.services;

import com.danielR.danielspring.models.License;
import com.danielR.danielspring.models.Permission;
import com.danielR.danielspring.repositories.LicenseRepository;
import com.danielR.danielspring.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository repository;

    public List<Permission> findAllPermissions() {
        return this.repository.findAll();
    }
}
