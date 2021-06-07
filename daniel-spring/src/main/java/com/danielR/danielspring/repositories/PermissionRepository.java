package com.danielR.danielspring.repositories;

import com.danielR.danielspring.models.Permission;
import com.danielR.danielspring.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {
    List<Permission> findAll();

}
