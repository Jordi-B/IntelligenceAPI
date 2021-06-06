package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.services.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()

@RequestMapping("/api/words")

public class WordsController {
    @Autowired
    WordsService wordsService;
}
