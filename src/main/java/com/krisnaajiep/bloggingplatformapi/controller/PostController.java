package com.krisnaajiep.bloggingplatformapi.controller;

/*
IntelliJ IDEA 2025.1 (Ultimate Edition)
Build #IU-251.23774.435, built on April 14, 2025
@Author krisna a.k.a. Krisna Ajie
Java Developer
Created on 05/05/25 23.01
@Last Modified 05/05/25 23.01
Version 1.0
*/

import com.krisnaajiep.bloggingplatformapi.dto.PostRequestDTO;
import com.krisnaajiep.bloggingplatformapi.dto.PostResponseDTO;
import com.krisnaajiep.bloggingplatformapi.service.PostService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody PostRequestDTO postRequestDTO) {
        return null;
    }

    @PutMapping(
            path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PostResponseDTO> updatePost(
            @PathVariable Integer id,
            @RequestBody PostRequestDTO postRequestDTO) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Integer id) {

    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PostResponseDTO> getPostById(@PathVariable Integer id) {
        return null;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PostRequestDTO>> getAllPosts() {
        return null;
    }
}
