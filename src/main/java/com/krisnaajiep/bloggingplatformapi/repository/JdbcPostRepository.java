package com.krisnaajiep.bloggingplatformapi.repository;

/*
IntelliJ IDEA 2025.1 (Ultimate Edition)
Build #IU-251.23774.435, built on April 14, 2025
@Author krisna a.k.a. Krisna Ajie
Java Developer
Created on 05/05/25 22.32
@Last Modified 05/05/25 22.32
Version 1.0
*/

import com.krisnaajiep.bloggingplatformapi.mapper.PostRowMapper;
import com.krisnaajiep.bloggingplatformapi.model.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class JdbcPostRepository implements PostRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcPostRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Post save(Post post) {
        String sql = "INSERT INTO Post (title, content, category, tags) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            ps.setString(3, post.getCategory());
            ps.setString(4, post.getTags());
            return ps;
        }, keyHolder);

        Integer newId = Objects.requireNonNull(keyHolder.getKey()).intValue();
        return jdbcTemplate.queryForObject("SELECT * FROM Post WHERE id = ?", new PostRowMapper(), newId);
    }

    @Override
    public Post update(Post post) {
        String sql = "UPDATE Post SET title = ?, content = ?, category = ?, tags = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(
                sql,
                post.getTitle(),
                post.getContent(),
                post.getCategory(),
                post.getTags(),
                post.getId()
        );

        if (rowsAffected == 0) {
            return null;
        } else {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Post WHERE id = ?",
                    new PostRowMapper(),
                    post.getId()
            );
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM Post WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        if (rowsAffected == 0) {
            throw new IllegalArgumentException("Post with id " + id + " not found");
        }
    }

    @Override
    public Optional<Post> findById(Integer id) {
        String sql = "SELECT * FROM Post WHERE id = ?";

        try {
            Post post = jdbcTemplate.queryForObject(sql, new PostRowMapper(), id);
            return Optional.ofNullable(post);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Post> findAll(String term) {
        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM Post");

        if (term != null) {
            sqlBuilder.append(" WHERE LOWER(title) LIKE LOWER(CONCAT('%', ?, '%')) ")
                    .append("OR LOWER(content) LIKE LOWER(CONCAT('%', ?, '%')) ")
                    .append("OR LOWER(category) LIKE LOWER(CONCAT('%', ?, '%'))");

            return jdbcTemplate.query(sqlBuilder.toString(), new PostRowMapper(), term, term, term);
        }

        return jdbcTemplate.query(sqlBuilder.toString(), new PostRowMapper());
    }
}
