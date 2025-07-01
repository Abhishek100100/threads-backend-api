package com.threads_api.threads_api.repository;

import com.threads_api.threads_api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // You can add custom queries here later if needed
}
