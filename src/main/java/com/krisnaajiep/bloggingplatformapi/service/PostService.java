package com.krisnaajiep.bloggingplatformapi.service;

/*
IntelliJ IDEA 2025.1 (Ultimate Edition)
Build #IU-251.23774.435, built on April 14, 2025
@Author krisna a.k.a. Krisna Ajie
Java Developer
Created on 05/05/25 22.35
@Last Modified 05/05/25 22.35
Version 1.0
*/

import com.krisnaajiep.bloggingplatformapi.dto.PostRequestDTO;
import com.krisnaajiep.bloggingplatformapi.dto.PostResponseDTO;

import java.util.List;

public interface PostService {
    PostResponseDTO createPost(PostRequestDTO postRequestDTO);
    PostResponseDTO updatePost(Integer id, PostRequestDTO postRequestDTO);
    void deletePost(Integer id);
    PostResponseDTO getPostById(Integer id);
    List<PostResponseDTO> getAllPosts(String term);
}
