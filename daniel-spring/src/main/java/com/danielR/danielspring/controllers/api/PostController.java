package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.DTOs.PostCounterDTO;
import com.danielR.danielspring.DTOs.PostDTO;
import com.danielR.danielspring.services.PostService;
import com.danielR.danielspring.scrapeObjects.scrapeProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;

@RestController()

@RequestMapping("/api/posts")
@CrossOrigin
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

    @GetMapping("/recent")
    public List<PostDTO> getRecentSuspectedPosts() {
        return this.postService.getRecentSuspectedPosts();
    }

    @GetMapping("/counts28/{id}")
    public List<PostCounterDTO> getPostCounts(@PathVariable String id){
        List<PostCounterDTO> p = this.postService.get28PostCounters(id);
        return p;
    }

    @PostMapping("/addScraping")
    public void addPostsFromScraping(@RequestBody List<scrapeProfile> scrapeProfiles ,HttpServletResponse response) {
        try {
            response.setStatus(postService.addPostsFromScraping(scrapeProfiles) ? 201 : 202); ;
        } catch (ParseException e) {
            response.setStatus(400);
        }
    }
}
