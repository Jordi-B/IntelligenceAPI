package com.danielR.danielspring.repositories;

import com.danielR.danielspring.models.Suspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuspectRepository extends JpaRepository<Suspect, String> {
    List<Suspect> findAll();
    List<Suspect> findByIsWantedTrue();
}
