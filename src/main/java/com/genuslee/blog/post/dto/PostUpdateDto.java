package com.genuslee.blog.post.dto;

import com.genuslee.blog.category.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateDto {
    private String title;
    private String description;
    private String photo;
    private List<Category> category;
}
