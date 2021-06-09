package com.danielR.danielspring.services;

import com.danielR.danielspring.DTOs.PostDTO;
import com.danielR.danielspring.models.Person;
import com.danielR.danielspring.models.Post;
import com.danielR.danielspring.repositories.PostRepository;
import com.danielR.danielspring.scrapeObjects.scrapeData;
import com.danielR.danielspring.scrapeObjects.scrapeProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    @Autowired
    private WordService wordService;

    @Autowired
    private PersonService personService;

    final SimpleDateFormat postDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

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

//    public List<Post> getSuspectedPosts() {
//        ArrayList<Post> suspectedPosts = new ArrayList<>();
//        List<Post> posts = this.repository.findAll();
//
//        return suspectedPosts;
//    }

    public List<Post> getPostsContainWord(String word) {
        return this.repository.findByTextContaining(word);
    }

    public List<Post> getRecentPostsContainWord(String word) {
        Date lastDay = new Date();
        lastDay.setDate(lastDay.getDate() -2);
        return this.repository.findByTextContainingAndPublishDateAfter(word, lastDay);
    }

    public boolean addPostsFromScraping(List<scrapeProfile> scrapeProfiles) throws ParseException {
        boolean newPostsAdded = false;

        for(scrapeProfile curScrapeProfile : scrapeProfiles){
            Person curPerson = personService.getPersonById(curScrapeProfile.getPerson_id());

            if(curPerson != null){
                List<Post> curProfilePosts = new ArrayList<>(this.repository.findByPersonId_Id(curScrapeProfile.getPerson_id()));

                for(scrapeData curScrapeData : curScrapeProfile.getData()){
                    Post newPost = new Post();
                    newPost.setPersonId(curPerson);
                    newPost.setText(curScrapeData.getText());
                    newPost.setPublishDate(postDateFormat.parse(curScrapeData.getPublish_date()));
                    newPost.setScrapingDate(postDateFormat.parse(curScrapeData.getScraping_date()));

                    if(!isPostInList(curProfilePosts, newPost)){
                        this.repository.save(newPost);
                        newPostsAdded = true;
                    }
                }
            }
        }

        return newPostsAdded;
    }

    public boolean isPostInList(List<Post> postList, Post queryPost){
        boolean isPostInList = false;

        for(Post curPost : postList) {
            if (curPost.getPersonId().equals(queryPost.getPersonId())
                    && curPost.getText().equals(queryPost.getText())
                    && curPost.getPublishDate().equals(queryPost.getPublishDate())
                    && curPost.getScrapingDate().equals(queryPost.getScrapingDate())) {
                isPostInList = true;
                break;
            }
        }

        return isPostInList;
    }
}
