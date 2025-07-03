package com.threads_api.threads_api.controller;

import com.threads_api.threads_api.model.Follow;
import com.threads_api.threads_api.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/follows")
public class FollowController {
    @Autowired
    private FollowRepository followRepository;

    @GetMapping
    public List<Follow> getAllFollows() {
        return followRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Follow> getFollowById(@PathVariable Long id) {
        return followRepository.findById(id);
    }

    @PostMapping
    public Follow createFollow(@RequestBody Follow follow) {
        follow.setCreatedAt(LocalDateTime.now());
        // set follower and following as you already do
        return followRepository.save(follow);
    }


    @DeleteMapping("/{id}")
    public void deleteFollow(@PathVariable Long id) {
        followRepository.deleteById(id);
    }
}
