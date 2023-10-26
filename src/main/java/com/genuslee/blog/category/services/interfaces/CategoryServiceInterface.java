package com.genuslee.blog.category.services.interfaces;

import com.genuslee.blog.category.dto.CategoryCreateDto;
import com.genuslee.blog.category.dto.CategoryUpdateDto;
import com.genuslee.blog.category.entities.Category;

import java.util.List;

public interface CategoryServiceInterface {
    Category findCategoryById(Long categoryId);

    Category createCategory(CategoryCreateDto categoryCreateDto);

    Category updateCategory(CategoryUpdateDto categoryUpdateDto);

    List<Category> findAllCategories();
    List<Category> findAllCategoriesByCategoryIds(List<Long> categoryIds);

    String deleteCategory(Long categoryId);

}
