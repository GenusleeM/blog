package com.genuslee.blog.category.controller;

import com.genuslee.blog.category.dto.CategoryCreateDto;
import com.genuslee.blog.category.entities.Category;
import com.genuslee.blog.category.services.implementation.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryCreateDto categoryCreateDto){
        try {
            Category category = categoryService.createCategory(categoryCreateDto);
            return new ResponseEntity<>(category,HttpStatus.CREATED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
