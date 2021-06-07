package com.danielR.danielspring.repositories;

import com.danielR.danielspring.models.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends JpaRepository<License, String> {
    List<License> findAll();
}
