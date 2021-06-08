package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.DTOs.WordDTO;
import com.danielR.danielspring.models.Word;
import com.danielR.danielspring.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()

@RequestMapping("/api/words")
@CrossOrigin
public class WordController {
    @Autowired
    WordService wordService;

    @GetMapping("")
    public List<WordDTO> getAllWords() {
        return this.wordService.findAllWords();
    }

    @DeleteMapping("")
    public int deleteWord(@RequestBody Map<String, String> json) {
        return this.wordService.deleteWord(json.get("word"));
    }

    @GetMapping("/recent")
    public List<WordDTO> getRecentWords() {
        return this.wordService.findRecentWords();
    }

    @PostMapping("/add")
    public int addWord(@RequestBody Map<String, String> json) {
        return this.wordService.addWord(json.get("word"));
    }

    @PostMapping("/replace")
    public int replaceWord(@RequestBody Map<String, String> json) {
        return this.wordService.replaceWord(json.get("addWord"), json.get("deleteWord"));
    }
}
