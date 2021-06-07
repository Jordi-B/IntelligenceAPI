package com.danielR.danielspring.services;

import com.danielR.danielspring.models.Post;
import com.danielR.danielspring.models.Suspect;
import com.danielR.danielspring.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> findAllPosts() {
        return this.repository.findAll();
    }

    public void addWordToBadWords(String word){
        List<Post> posts = this.getPostsContainWord(word);

        for(Post post : posts){
            post.getListOfBadWords().add(word);
            this.repository.save(post);
        }
    }

    public List<Post> getPostsContainWord(String word) {
        return this.repository.findByTextContaining(word);
    }
}
