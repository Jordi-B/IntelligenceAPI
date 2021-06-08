package com.danielR.danielspring.services;

import com.danielR.danielspring.DTOs.WordDTO;
import com.danielR.danielspring.models.Post;
import com.danielR.danielspring.models.Word;
import com.danielR.danielspring.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {
    @Autowired
    private WordRepository repository;

    @Autowired
    private PostService postService;

    public List<WordDTO> findAllWords() {
        ArrayList<WordDTO> words = new ArrayList<>();

        for(Word word : this.repository.findAll()){
            WordDTO newWord = new WordDTO();
            newWord.setWord(word.getWord());
            newWord.setCounter(this.getWordCounter(word.getWord()));
            newWord.setPercentageOfPosts(this.getPostPercentage(word.getWord()));

            words.add(newWord);
        }

        return words;
    }


    public List<WordDTO> findRecentWords() {
        ArrayList<WordDTO> words = new ArrayList<>();

        for(Word word : this.repository.findAll()){
            WordDTO newWord = new WordDTO();
            newWord.setWord(word.getWord());
            newWord.setCounter(this.getRecentWordCounter(word.getWord()));
            newWord.setPercentageOfPosts(this.getRecentPostPercentage(word.getWord()));

            words.add(newWord);
        }

        return words;
    }

    public List<WordDTO> findRecentWordsPercentage() {
        ArrayList<WordDTO> words = new ArrayList<>();

        for(Word word : this.repository.findAll()){
            WordDTO newWord = new WordDTO();
            newWord.setWord(word.getWord());
            newWord.setCounter(this.getRecentWordPercentageCounter(word.getWord()));
            newWord.setPercentageOfPosts(this.getRecentPostPercentage(word.getWord()));

            words.add(newWord);
        }

        return words;
    }

    private int getRecentWordPercentageCounter(String word) {
        List<Post> posts = this.postService.getRecentPostsContainWord(word);
        int counter = 0;

        for(Post post : posts){
            if (post.getText().contains(word)) {
                counter++;
            }
        }

        return counter;
    }

    public int addWord(String newWord) {
        if(this.repository.findByWord(newWord) != null){
            return 300;
        }

        Word word = new Word();
        word.setWord(newWord);
        return this.repository.save(word) != null ? 200 : 400;
    }

    private int getWordCounter(String word){
        List<Post> posts = this.postService.getPostsContainWord(word);
        int counter = 0;

        for(Post post : posts){
            counter += post.getText().split(word).length;
            if (!post.getText().endsWith(word)) {
                counter--;
            }
        }

        return counter;
    }

    private int getRecentWordCounter(String word){
        List<Post> posts = this.postService.getRecentPostsContainWord(word);
        int counter = 0;

        for(Post post : posts){
            counter += post.getText().split(word).length;
            if (!post.getText().endsWith(word)) {
                counter--;
            }
        }

        return counter;
    }

    public int deleteWord(String word){
        try{
            Word deleteWord = this.repository.findByWord(word);
            this.repository.delete(deleteWord);
        }
        catch(Exception ex){
            return 400;
        }
        return 200;
    }

    private int getPostPercentage(String word){
        return (int)(((float)this.postService.getPostsContainWord(word).size()) /
                ((float)this.postService.findAllPosts().size()) * 100);
    }

    private int getRecentPostPercentage(String word) {
        return (int)(((float)this.postService.getRecentPostsContainWord(word).size()) /
                ((float)this.postService.findAllPosts().size()) * 100);
    }

    public ArrayList<Word> getBadWordsInPost(String text){
        List<Word> words = this.repository.findAll();
        ArrayList<Word> badWords = new ArrayList<>();

        for(Word word : words){
            if(text.contains(word.getWord())){
                badWords.add(word);
            }
        }

        return badWords;
    }

    public int replaceWord(String newWord, String word){
        try{
            Word deleteWord = this.repository.findByWord(word);
            this.repository.delete(deleteWord);
        }
        catch(Exception ex){
            return 400;
        }

        if(this.repository.findByWord(newWord) != null){
            return 300;
        }

        Word addWord = new Word(newWord);
        this.repository.save(addWord);
        return 200;
    }
}
