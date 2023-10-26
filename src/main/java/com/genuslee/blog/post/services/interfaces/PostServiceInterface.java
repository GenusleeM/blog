package com.genuslee.blog.post.services.interfaces;

import com.genuslee.blog.category.dto.CategoryCreateDto;
import com.genuslee.blog.category.dto.CategoryUpdateDto;
import com.genuslee.blog.category.entities.Category;
import com.genuslee.blog.post.dto.PostCreateDto;
import com.genuslee.blog.post.dto.PostUpdateDto;
import com.genuslee.blog.post.entities.Post;

import java.util.List;

public interface PostServiceInterface {

    Post findPostById(Long postId);

    Post createPost(PostCreateDto postCreateDto);

    Post updatePost(PostUpdateDto postUpdateDto);

    List<Post> findAllPosts();

    String deletePost(Long postId);

}
