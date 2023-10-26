package com.genuslee.blog.post.dto;

import com.genuslee.blog.category.entities.Category;
import com.genuslee.blog.user.entities.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateDto {
    private Long userId;
    private String title;
    private String description;
    private String photo;
    private List<Long> categoryIds;
}
