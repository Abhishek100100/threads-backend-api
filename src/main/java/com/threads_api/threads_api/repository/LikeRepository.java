package com.threads_api.threads_api.repository;

import com.threads_api.threads_api.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
