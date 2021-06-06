package com.danielR.danielspring.repositories;

import com.danielR.danielspring.models.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends CrudRepository<License, String> {
}
