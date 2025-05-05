package com.krisnaajiep.bloggingplatformapi.dto;

/*
IntelliJ IDEA 2025.1 (Ultimate Edition)
Build #IU-251.23774.435, built on April 14, 2025
@Author krisna a.k.a. Krisna Ajie
Java Developer
Created on 05/05/25 22.36
@Last Modified 05/05/25 22.36
Version 1.0
*/

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class PostRequestDTO {
    @NonNull
    @NotBlank
    @Size(max = 255)
    private String title;

    @NonNull
    @NotBlank
    @Size(max = 10000)
    private String content;

    @NonNull
    @NotBlank
    @Size(max = 255)
    private String category;

    @NonNull
    @NotEmpty
    @Size(min = 1, max = 20)
    private List<@NotBlank String> tags;
}
