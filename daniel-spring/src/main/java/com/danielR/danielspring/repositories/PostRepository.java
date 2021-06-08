package com.danielR.danielspring.repositories;

import com.danielR.danielspring.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    List<Post> findByTextContaining(String word);
    List<Post> findAll();
    List<Post> findByPersonId_Id(String personId);
    int countByPersonId_IdAndPublishDateAfter(String personId, Date publishDate);
    List<Post> findAllByPublishDateAfter(Date publishDate);
}