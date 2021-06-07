package com.danielR.danielspring.controllers.api;


import com.danielR.danielspring.models.Suspect;
import com.danielR.danielspring.services.SuspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
