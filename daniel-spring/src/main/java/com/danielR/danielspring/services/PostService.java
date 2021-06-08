package com.danielR.danielspring.services;

import com.danielR.danielspring.DTOs.PostCounterDTO;
import com.danielR.danielspring.DTOs.PostDTO;
import com.danielR.danielspring.models.Post;
import com.danielR.danielspring.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    @Autowired
    private WordService wordService;

    public List<PostDTO> findAllPosts() {
        ArrayList<PostDTO> posts = new ArrayList<>();

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

    public List<PostDTO> getPostsByPersonId(String id) {
        ArrayList<PostDTO> posts = new ArrayList<PostDTO>();

        for(Post post : this.repository.findByPersonId_Id(id)){
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

    public List<PostDTO> getRecentSuspectedPosts() {
        ArrayList<PostDTO> posts = new ArrayList<PostDTO>();
        Date lastDay = new Date();
        lastDay.setDate(lastDay.getDate() -2);
        for(Post post : this.repository.findAllByPublishDateAfter(lastDay)){
            PostDTO newPost = new PostDTO();
            newPost.setListOfBadWords(wordService.getBadWordsInPost(post.getText()));
            if (newPost.getListOfBadWords().size() > 0) {
                newPost.setId(post.getId());
                newPost.setPersonId(post.getPersonId());
                newPost.setPublishDate(post.getPublishDate());
                newPost.setScrapingDate(post.getScrapingDate());
                newPost.setText(post.getText());
                posts.add(newPost);
            }
        }
        return posts;
    }

    public int getPostCountForThePastWeek(String id) {
        Date date = new Date();
        date.setDate(date.getDate() - 8);
        return this.repository.countByPersonId_IdAndPublishDateAfter(id, date);
    }

    public List<Post> getPostsContainWord(String word) {
        return this.repository.findByTextContaining(word);
    }

    public List<Post> getRecentPostsContainWord(String word) {
        Date lastDay = new Date();
        lastDay.setDate(lastDay.getDate() -2);
        return this.repository.findByTextContainingAndPublishDateAfter(word, lastDay);
    }

    public List<PostCounterDTO> get28PostCounters(){
        ArrayList<PostCounterDTO> postCounts  = new ArrayList<>();
        Date lastDay = new Date();
        lastDay.setDate(lastDay.getDate() - 1);
        for(int i = 0 ; i < 28 ; i++){
                PostCounterDTO newPostCounter = new PostCounterDTO();

            lastDay.setDate(lastDay.getDate() - 1);
        }

        return postCounts;
    }
}
