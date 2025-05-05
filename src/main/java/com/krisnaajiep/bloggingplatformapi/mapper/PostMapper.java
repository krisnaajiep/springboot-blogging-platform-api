package com.krisnaajiep.bloggingplatformapi.mapper;

/*
IntelliJ IDEA 2025.1 (Ultimate Edition)
Build #IU-251.23774.435, built on April 14, 2025
@Author krisna a.k.a. Krisna Ajie
Java Developer
Created on 05/05/25 22.50
@Last Modified 05/05/25 22.50
Version 1.0
*/

import com.krisnaajiep.bloggingplatformapi.dto.PostRequestDTO;
import com.krisnaajiep.bloggingplatformapi.dto.PostResponseDTO;
import com.krisnaajiep.bloggingplatformapi.model.Post;

import java.util.Arrays;
import java.util.List;

public class PostMapper {
    public static Post toPost(PostRequestDTO postRequestDTO) {
        Post post = new Post();

        post.setTitle(postRequestDTO.getTitle());
        post.setContent(postRequestDTO.getContent());
        post.setCategory(postRequestDTO.getCategory());
        post.setTags(postRequestDTO.getTags().toString());

        return post;
    }

    public static PostResponseDTO toPostResponseDTO(Post post) {
        return new PostResponseDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCategory(),
                parseTagsString(post.getTags()),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }

    private static List<String> parseTagsString(String tags) {
        return Arrays.asList(
                tags.replaceAll("[\\[\\]]", "")
                        .split(",")
        );
    }
}
