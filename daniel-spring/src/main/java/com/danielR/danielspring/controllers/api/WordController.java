package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.DTOs.WordDTO;
import com.danielR.danielspring.models.Word;
import com.danielR.danielspring.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()

@RequestMapping("/api/words")

public class WordController {
    @Autowired
    WordService wordService;

    @GetMapping("")
    public List<WordDTO> getAllWords() {
        return this.wordService.findAllWords();
    }

    @GetMapping("/delete/{word}")
    public int deleteWord(@PathVariable("word") String word) {
        return this.wordService.deleteWord(word) == null ? 200 : 401;
    }

    @GetMapping("/add")
    public int addWord(@RequestBody String word) {
        return this.wordService.addWord(word) != null ? 200 : 401;
    }
}
