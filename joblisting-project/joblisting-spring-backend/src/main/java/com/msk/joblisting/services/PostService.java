package com.msk.joblisting.services;

import com.msk.joblisting.model.Post;
import com.msk.joblisting.repositories.PostRepository;
import com.msk.joblisting.repositories.SearchPostRepositoryImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Slf4j
@Service
public class PostService {

    private final PostRepository postRepository;
    private final SearchPostRepositoryImp searchPostRepository;

    public PostService(PostRepository postRepository, SearchPostRepositoryImp searchPostRepository) {
        this.postRepository = postRepository;
        this.searchPostRepository = searchPostRepository;
    }

    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        log.info("Getting all {} posts", posts.size());
        return posts;
    }

    public Post save(Post post) {
        try {
            Post savedPost = postRepository.save(post);
            log.info("Saved post with id: {}", savedPost.getId());
            return savedPost;
        } catch (DataAccessException e) {
            log.error("Failed to save post", e);
            throw new RuntimeException("Failed to save post: " + e.getMessage(), e);
        }
    }

    public List<Post> searchByKeyWord(String text) {
        return searchPostRepository.searchByKeyWord(text);
    }
}
