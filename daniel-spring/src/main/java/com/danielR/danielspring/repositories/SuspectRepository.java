package com.danielR.danielspring.repositories;

import com.danielR.danielspring.models.Suspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuspectRepository extends JpaRepository<Suspect, String> {
}
