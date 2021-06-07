package com.danielR.danielspring.services;

import com.danielR.danielspring.models.Post;
import com.danielR.danielspring.models.Suspect;
import com.danielR.danielspring.models.Word;
import com.danielR.danielspring.repositories.SuspectRepository;
import com.danielR.danielspring.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {
    @Autowired
    private WordRepository repository;

    private PostService postService;

    public void addWord(String newWord) {
        Word word = new Word();
        word.setWord(newWord);


        this.repository.save(word);
    }

    private int getWordCounter(String word){
        List<Post> posts = postService.getPostsContainWord(word);
        int counter = 0;

        for(Post post : posts){
            counter += post.getText().split(word).length - 1;
        }

        return counter;
    }
}
