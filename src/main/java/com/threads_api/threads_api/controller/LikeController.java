package com.threads_api.threads_api.controller;

import com.threads_api.threads_api.model.Like;
import com.threads_api.threads_api.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    private LikeRepository likeRepository;

    @GetMapping
    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Like> getLikeById(@PathVariable Long id) {
        return likeRepository.findById(id);
    }

    @PostMapping
    public Like createLike(@RequestBody Like like) {
        return likeRepository.save(like);
    }

    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable Long id) {
        likeRepository.deleteById(id);
    }
}
