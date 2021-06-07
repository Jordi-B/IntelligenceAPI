package com.danielR.danielspring.services;

import com.danielR.danielspring.DTOs.PostDTO;
import com.danielR.danielspring.models.Post;
import com.danielR.danielspring.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    @Autowired
    private WordService wordService;

    public List<PostDTO> findAllPosts() {
        ArrayList<PostDTO> posts = new ArrayList<PostDTO>();

        for(Post post : this.repository.findAll()){
            PostDTO newPost = new PostDTO();
            newPost.setId(post.getId());
            newPost.setPersonId(post.getPersonId());
            newPost.setPublishDate(post.getPublishDate());
            newPost.setScrapingDate(post.getScrapingDate());
            newPost.setText(post.getText());
            newPost.setListOfBadWords(wordService.getBadWordsInPost(post.getText()));

            posts.add(newPost);
        }

        return posts;
    }

//    public void addWordToBadWords(String word){
//        List<Post> posts = this.getPostsContainWord(word);
//
//        for(Post post : posts){
//            ArrayList<Word> words = post.getListOfBadWords();
//            words.add(word);
//            post.setListOfBadWords(words);
//            this.repository.save(post);
//        }
//    }

    public List<Post> getPostsContainWord(String word) {
        return this.repository.findByTextContaining(word);
    }
}
