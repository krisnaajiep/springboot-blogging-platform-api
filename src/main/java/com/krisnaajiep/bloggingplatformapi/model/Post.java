package com.krisnaajiep.bloggingplatformapi.model;

/*
IntelliJ IDEA 2025.1 (Ultimate Edition)
Build #IU-251.23774.435, built on April 14, 2025
@Author krisna a.k.a. Krisna Ajie
Java Developer
Created on 05/05/25 16.55
@Last Modified 05/05/25 16.55
Version 1.0
*/

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {
    private Integer id;
    private String title;
    private String content;
    private String category;
    private String tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
