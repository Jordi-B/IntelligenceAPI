package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.models.License;
import com.danielR.danielspring.models.Permission;
import com.danielR.danielspring.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()

@RequestMapping("/api/permissions")

public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @GetMapping("")
    public List<Permission> getAllPermissions() {
        return this.permissionService.findAllPermissions();
    }
}
