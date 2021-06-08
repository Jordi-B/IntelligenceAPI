package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.models.License;
import com.danielR.danielspring.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()

@RequestMapping("/api/licenses")
@CrossOrigin
public class LicenseController {
    @Autowired
    LicenseService licenseService;

    @GetMapping("")
    public List<License> getAllLicenses() {
        return this.licenseService.findAllLicenses();
    }
}
