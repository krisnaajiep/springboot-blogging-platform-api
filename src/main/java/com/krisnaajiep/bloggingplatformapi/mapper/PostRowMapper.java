package com.krisnaajiep.bloggingplatformapi.mapper;

/*
IntelliJ IDEA 2025.1 (Ultimate Edition)
Build #IU-251.23774.435, built on April 14, 2025
@Author krisna a.k.a. Krisna Ajie
Java Developer
Created on 05/05/25 22.44
@Last Modified 05/05/25 22.44
Version 1.0
*/

import com.krisnaajiep.bloggingplatformapi.model.Post;
import lombok.NonNull;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper implements RowMapper<Post> {
    @Override
    public Post mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setId(rs.getInt("Id"));
        post.setTitle(rs.getString("Title"));
        post.setContent(rs.getString("Content"));
        post.setCategory(rs.getString("Category"));
        post.setTags(rs.getString("Tags"));
        post.setCreatedAt(rs.getTimestamp("CreatedAt").toLocalDateTime());
        post.setUpdatedAt(rs.getTimestamp("UpdatedAt").toLocalDateTime());
        return post;
    }
}
