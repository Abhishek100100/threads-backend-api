package com.threads_api.threads_api.repository;

import com.threads_api.threads_api.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
}
