package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.DTOs.PostDTO;
import com.danielR.danielspring.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()

@RequestMapping("/api/posts")

public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("")
    public List<PostDTO> getAllPosts() {
        return this.postService.findAllPosts();
    }

    @GetMapping("/person/{id}")
    public List<PostDTO> getPostsByPersonId(@PathVariable String id) {
        return this.postService.getPostsByPersonId(id);
    }

    @GetMapping("/person/count/{id}")
    public int getPostCountById(@PathVariable String id) {
        return this.postService.getPostCountForThePastWeek(id);
    }
}
