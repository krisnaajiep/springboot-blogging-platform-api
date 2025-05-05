package com.krisnaajiep.bloggingplatformapi.service;

/*
IntelliJ IDEA 2025.1 (Ultimate Edition)
Build #IU-251.23774.435, built on April 14, 2025
@Author krisna a.k.a. Krisna Ajie
Java Developer
Created on 05/05/25 23.00
@Last Modified 05/05/25 23.00
Version 1.0
*/

import com.krisnaajiep.bloggingplatformapi.dto.PostRequestDTO;
import com.krisnaajiep.bloggingplatformapi.dto.PostResponseDTO;
import com.krisnaajiep.bloggingplatformapi.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostResponseDTO createPost(PostRequestDTO postRequestDTO) {
        return null;
    }

    @Override
    public PostResponseDTO updatePost(Integer id, PostRequestDTO postRequestDTO) {
        return null;
    }

    @Override
    public void deletePost(Integer id) {

    }

    @Override
    public PostResponseDTO getPostById(Integer id) {
        return null;
    }

    @Override
    public List<PostRequestDTO> getAllPosts() {
        return List.of();
    }
}
