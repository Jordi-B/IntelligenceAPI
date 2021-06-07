package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.models.Person;
import com.danielR.danielspring.models.Post;
import com.danielR.danielspring.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()

@RequestMapping("/api/posts")

public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("")
    public List<Post> getAllPosts() {
        return this.postService.findAllPosts();
    }
}
