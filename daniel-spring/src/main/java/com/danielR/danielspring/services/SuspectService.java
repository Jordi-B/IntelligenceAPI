package com.danielR.danielspring.services;

import com.danielR.danielspring.DTOs.PostDTO;
import com.danielR.danielspring.DTOs.SuspectDTO;
import com.danielR.danielspring.exceptions.IdNotFoundException;
import com.danielR.danielspring.models.Post;
import com.danielR.danielspring.models.Suspect;
import com.danielR.danielspring.models.Word;
import com.danielR.danielspring.repositories.SuspectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SuspectService {
    @Autowired
    private SuspectRepository repository;

    @Autowired
    private PostService postService;



    public List<Suspect> findAllSuspects() {
        return this.repository.findAll();
    }

    public List<Suspect> findAllWanteds() {
        return this.repository.findByIsWantedTrue();
    }

    public boolean isSuspected(String personId) {
        return this.repository.existsById(personId);
    }

    public Suspect getSuspectById(String id) {
        return this.repository.findByPersonId(id).orElse(null);
    }

    public void setSuspectAsWanted(String id) throws IdNotFoundException{
        Suspect suspect = this.repository.findByPersonId(id).orElseThrow(IdNotFoundException::new);
        suspect.setWanted(true);
        suspect.setStarted(new Date());
        this.repository.save(suspect);
    }

    public List<SuspectDTO> getSuspectListWithBadWords() {
        List<Suspect> suspectList = this.repository.findAll();
        ArrayList<SuspectDTO> newSuspectList = new ArrayList<>();
        for(Suspect suspect : suspectList) {
            SuspectDTO newSuspect = new SuspectDTO();
            newSuspect.setSuspect(suspect);
            ArrayList<Word> badWordsFound = new ArrayList<>();
            for(PostDTO post: this.postService.getPostsByPersonId(suspect.getPersonId())) {
                for (Word word: post.getListOfBadWords()) {
                    badWordsFound.add(word);
                }
            }
            newSuspect.setListOfBadWords(badWordsFound);
            newSuspectList.add(newSuspect);
        }
        return newSuspectList;
    }



}
