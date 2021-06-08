package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.models.License;
import com.danielR.danielspring.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public List<License> getLicensesById(@PathVariable String id) {
        return this.licenseService.getAllByPersonId(id);
    }
}
