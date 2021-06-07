package com.danielR.danielspring.services;

import com.danielR.danielspring.models.Post;
import com.danielR.danielspring.models.Word;
import com.danielR.danielspring.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {
    @Autowired
    private WordRepository repository;

    @Autowired
    private PostService postService;

    public List<Word> findAllWords() {
        return this.repository.findAll();
    }

    public Word addWord(String newWord) {
        Word word = new Word();
        word.setWord(newWord);
        word.setCounter(this.getWordCounter(newWord));
        word.setPercentageOfPosts(this.getPostPercentage(newWord));

        this.postService.addWordToBadWords(newWord);

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

    private void addWordToPostBadWords(String word){

    }

    private int getPostPercentage(String word){
        return (int)(((float)this.postService.getPostsContainWord(word).size()) /
                ((float)this.postService.findAllPosts().size()) * 100);
    }
}
