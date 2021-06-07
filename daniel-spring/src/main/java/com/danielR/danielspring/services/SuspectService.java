package com.danielR.danielspring.services;

import com.danielR.danielspring.data.repositories.PersonLikeRepository;
import com.danielR.danielspring.models.Person;
import com.danielR.danielspring.models.Suspect;
import com.danielR.danielspring.repositories.SuspectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuspectService {
    @Autowired
    private SuspectRepository repository;

    public List<Suspect> findAllSuspects() {
        return this.repository.findAll();
    }

    public List<Suspect> findAllWanteds() {
        return this.repository.findByIsWantedTrue();
    }

}
