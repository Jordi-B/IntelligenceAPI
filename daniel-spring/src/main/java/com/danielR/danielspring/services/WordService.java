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

    public Word addWord(String newWord) {
        Word word = new Word();
        word.setWord(newWord);

        return this.repository.save(word);
    }

    private int getWordCounter(String word){
        List<Post> posts = this.postService.getPostsContainWord(word);
        int counter = 0;

        for(Post post : posts){
            counter += post.getText().split(word).length - 1;
        }

        return counter;
    }

    public Word deleteWord(String word){
        Word deleteWord = this.repository.findByWord(word);

        this.repository.delete(deleteWord);
        return this.repository.findByWord(word);
    }

    private int getPostPercentage(String word){
        return (int)(((float)this.postService.getPostsContainWord(word).size()) /
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
}
