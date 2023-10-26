package com.genuslee.blog.post.controller;

import com.genuslee.blog.exception.ResourceNotFoundException;
import com.genuslee.blog.post.dto.PostCreateDto;
import com.genuslee.blog.post.entities.Post;
import com.genuslee.blog.post.services.implementation.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostServiceImpl postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostCreateDto postCreateDto){
        try {
             Post post = postService.createPost(postCreateDto);
             return new ResponseEntity<>(post, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<List<?>> findAllPosts(){
        try {

            List<Post> posts = postService.findAllPosts();

            return new  ResponseEntity<>(posts, HttpStatus.OK);
        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            return null;
        }
    }
}
