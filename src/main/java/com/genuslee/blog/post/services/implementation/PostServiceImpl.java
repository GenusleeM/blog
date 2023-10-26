package com.genuslee.blog.post.services.implementation;

import com.genuslee.blog.category.entities.Category;
import com.genuslee.blog.category.repositories.CategoryRepository;
import com.genuslee.blog.category.services.implementation.CategoryServiceImpl;
import com.genuslee.blog.exception.ResourceNotFoundException;
import com.genuslee.blog.post.dto.PostCreateDto;
import com.genuslee.blog.post.dto.PostUpdateDto;
import com.genuslee.blog.post.entities.Post;
import com.genuslee.blog.post.repositories.PostRepository;
import com.genuslee.blog.post.services.interfaces.PostServiceInterface;
import com.genuslee.blog.user.entities.User;
import com.genuslee.blog.user.services.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostServiceInterface {

    private final PostRepository postRepository;
    private final UserServiceImpl userService;
    private final CategoryServiceImpl categoryService;


    @Override
    public Post findPostById(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post with Id [%s] is not found".formatted(postId)));
    }

    @Override
    public Post createPost(PostCreateDto postCreateDto) {
        Post post = new Post();
        User user = userService.findUserById(postCreateDto.getUserId());
        List<Category> categories = categoryService.findAllCategoriesByCategoryIds(postCreateDto.getCategoryIds());
        post.setCategory(categories);
        post.setTitle(postCreateDto.getTitle());
        post.setPhoto(postCreateDto.getPhoto());
        post.setDescription(postCreateDto.getDescription());
        post.setPostOwner(user);
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public String deletePost(Long postId) {
        Post post = findPostById(postId);
        if (post != null){
         postRepository.deleteById(postId);
            return "Post with Id [%s] deleted successfully".formatted(postId);
        }else {
            return "Oops  post with id [%s] not found".formatted(postId);
        }
    }
    @Override
    public Post updatePost(PostUpdateDto postUpdateDto) {
        return null;
    }
}
