package com.krisnaajiep.bloggingplatformapi.dto;

/*
IntelliJ IDEA 2025.1 (Ultimate Edition)
Build #IU-251.23774.435, built on April 14, 2025
@Author krisna a.k.a. Krisna Ajie
Java Developer
Created on 05/05/25 22.38
@Last Modified 05/05/25 22.38
Version 1.0
*/

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostResponseDTO {
    private Integer id;
    private String title;
    private String content;
    private String category;
    private List<String> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
