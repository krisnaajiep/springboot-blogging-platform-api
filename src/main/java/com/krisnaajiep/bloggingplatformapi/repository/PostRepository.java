package com.krisnaajiep.bloggingplatformapi.repository;

/*
IntelliJ IDEA 2025.1 (Ultimate Edition)
Build #IU-251.23774.435, built on April 14, 2025
@Author krisna a.k.a. Krisna Ajie
Java Developer
Created on 05/05/25 22.07
@Last Modified 05/05/25 22.07
Version 1.0
*/

import com.krisnaajiep.bloggingplatformapi.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    Post update(Post post);
    void deleteById(Integer id);
    Optional<Post> findById(Integer id);
    List<Post> findAll(String term);
}
