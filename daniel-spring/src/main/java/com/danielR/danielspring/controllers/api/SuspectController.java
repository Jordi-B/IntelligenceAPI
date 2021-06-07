package com.danielR.danielspring.controllers.api;


import com.danielR.danielspring.models.Suspect;
import com.danielR.danielspring.services.SuspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()

@RequestMapping("/api/suspects")

public class SuspectController {
    @Autowired
    SuspectService suspectService;

    @GetMapping("")
    public List<Suspect> getAllSuspects() {
        return this.suspectService.findAllSuspects();
    }

    @GetMapping("/wanteds")
    public List<Suspect> getAllWanteds() {
        return this.suspectService.findAllWanteds();
    }

    @GetMapping("/suspected/{personId}")
    public boolean isSuspected(@PathVariable String personId) {
        return this.suspectService.isSuspected(personId);
    }

    @GetMapping("/suspect/{id}")
    public Suspect getSuspectById(@PathVariable String id) {
        return this.suspectService.getSuspectById(id);
    }
}
