package com.danielR.danielspring.controllers.api;


import com.danielR.danielspring.DTOs.SuspectDTO;
import com.danielR.danielspring.exceptions.IdNotFoundException;
import com.danielR.danielspring.models.Suspect;
import com.danielR.danielspring.services.SuspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()

@RequestMapping("/api/suspects")
@CrossOrigin
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

    @PatchMapping("/suspect/toggle/wanted")
    public int setSuspectAsWanted(@RequestBody String id) {
        try {
            this.suspectService.setSuspectAsWanted(id);
            return 200;
        } catch (IdNotFoundException e) {
            return 401;
        }
    }

    @GetMapping("/full")
    public List<SuspectDTO> getSuspectDTOs() {
        return this.suspectService.getSuspectListWithBadWords();
    }

    @GetMapping("/new")
    public List<Suspect> getNewSuspects() {
        return this.suspectService.getNewSuspects();
    }

    @GetMapping("/wanted/new")
    public List<Suspect> getNewWanted() {
        return this.suspectService.getNewWanteds();
    }

    @GetMapping("released/new")
    public List<Suspect> getNewReleased() {
        return this.suspectService.getNewReleased();
    }
}
