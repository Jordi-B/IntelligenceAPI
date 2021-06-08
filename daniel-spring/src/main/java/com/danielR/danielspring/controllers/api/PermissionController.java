package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.models.Permission;
import com.danielR.danielspring.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()

@RequestMapping("/api/permissions")
@CrossOrigin
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @GetMapping("")
    public List<Permission> getAllPermissions() {
        return this.permissionService.findAllPermissions();
    }

    @GetMapping("/{id}")
    public List<Permission> getLicensesById(@PathVariable String id) {
        return this.permissionService.getAllByPersonId(id);
    }
}
