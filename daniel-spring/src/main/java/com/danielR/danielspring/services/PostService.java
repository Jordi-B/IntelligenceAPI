package com.danielR.danielspring.services;

import com.danielR.danielspring.models.Post;
import com.danielR.danielspring.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> getPostsContainWord(String word) {
        return this.repository.findByTextContaining(word);
    }
}
