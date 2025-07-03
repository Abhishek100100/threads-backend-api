package com.threads_api.threads_api.config;

import com.threads_api.threads_api.model.*;
import com.threads_api.threads_api.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner seedDatabase(
            UserRepository userRepository,
            PostRepository postRepository,
            CommentRepository commentRepository,
            LikeRepository likeRepository,
            FollowRepository followRepository
    ) {
        return args -> {
            // --- USERS ---
            if (userRepository.findByUsername("rishabh") == null && userRepository.findByEmail("rishabh@gmail.com") == null) {
                User rishabh = new User();
                rishabh.setUsername("rishabh");
                rishabh.setEmail("rishabh@gmail.com");
                rishabh.setPasswordHash("password");
                rishabh.setCreatedAt(LocalDateTime.now());
                userRepository.save(rishabh);
            }

            if (userRepository.findByUsername("abhishek") == null && userRepository.findByEmail("abhishek@gmail.com") == null) {
                User abhishek = new User();
                abhishek.setUsername("abhishek");
                abhishek.setEmail("abhishek@gmail.com");
                abhishek.setPasswordHash("password");
                abhishek.setCreatedAt(LocalDateTime.now());
                userRepository.save(abhishek);
            }

            if (userRepository.findByUsername("kavya") == null && userRepository.findByEmail("kavya@gmail.com") == null) {
                User kavya = new User();
                kavya.setUsername("kavya");
                kavya.setEmail("kavya@gmail.com");
                kavya.setPasswordHash("password");
                kavya.setCreatedAt(LocalDateTime.now());
                userRepository.save(kavya);
            }

            // --- POSTS ---
            if (postRepository.count() == 0) {
                Post rishabhPost = new Post();
                rishabhPost.setContent("Namaste from rishabh! Excited to join Threads.");
                rishabhPost.setCreatedAt(LocalDateTime.now());
                // If you have a user field in Post:
                // rishabhPost.setUser(userRepository.findByUsername("rishabh"));
                postRepository.save(rishabhPost);

                Post abhishekPost = new Post();
                abhishekPost.setContent("abhishek here! Ready to connect with everyone.");
                abhishekPost.setCreatedAt(LocalDateTime.now());
                // abhishekPost.setUser(userRepository.findByUsername("abhishek"));
                postRepository.save(abhishekPost);
            }

            // --- COMMENTS ---
            if (commentRepository.count() == 0) {
                Comment comment1 = new Comment();
                comment1.setContent("Welcome rishabh!");
                comment1.setCreatedAt(LocalDateTime.now());
                // comment1.setPost(rishabhPost);
                // comment1.setUser(userRepository.findByUsername("abhishek"));
                commentRepository.save(comment1);

                Comment comment2 = new Comment();
                comment2.setContent("Glad to see you here, abhishek!");
                comment2.setCreatedAt(LocalDateTime.now());
                // comment2.setPost(abhishekPost);
                // comment2.setUser(userRepository.findByUsername("kavya"));
                commentRepository.save(comment2);
            }

            // --- LIKES ---
            if (likeRepository.count() == 0) {
                Like like1 = new Like();
                // like1.setUser(userRepository.findByUsername("kavya"));
                // like1.setPost(rishabhPost);
                likeRepository.save(like1);

                Like like2 = new Like();
                // like2.setUser(userRepository.findByUsername("rishabh"));
                // like2.setPost(abhishekPost);
                likeRepository.save(like2);
            }

            // --- FOLLOWS ---
            if (followRepository.count() == 0) {
                Follow follow1 = new Follow();
                // follow1.setFollower(userRepository.findByUsername("abhishek"));
                // follow1.setFollowing(userRepository.findByUsername("rishabh"));
                followRepository.save(follow1);

                Follow follow2 = new Follow();
                // follow2.setFollower(userRepository.findByUsername("kavya"));
                // follow2.setFollowing(userRepository.findByUsername("abhishek"));
                followRepository.save(follow2);
            }

            // --- Comments ---
            // Uncomment and adjust the setUser/setPost/setFollower/setFollowing lines above
            // to match your actual entity relationships (foreign keys).
        };
    }
}
