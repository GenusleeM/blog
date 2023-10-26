package com.genuslee.blog.category.services.implementation;

import com.genuslee.blog.category.dto.CategoryCreateDto;
import com.genuslee.blog.category.dto.CategoryUpdateDto;
import com.genuslee.blog.category.entities.Category;
import com.genuslee.blog.category.repositories.CategoryRepository;
import com.genuslee.blog.category.services.interfaces.CategoryServiceInterface;
import com.genuslee.blog.exception.ResourceNotFoundException;
import com.genuslee.blog.user.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryServiceInterface {
    private final CategoryRepository categoryRepository;
    @Override
    public Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category with id [%s] not found ".formatted(categoryId)));
    }

    @Override
    public Category createCategory(CategoryCreateDto categoryCreateDto) {
        Category  category= new Category();
        category.setCategoryName(categoryCreateDto.getCategoryName());
        return categoryRepository.save(category);
    }


    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAllCategoriesByCategoryIds(List<Long> categoryIds) {
        return categoryRepository.findAllById(categoryIds);
    }


    @Override
    public Category updateCategory(CategoryUpdateDto categoryUpdateDto) {
        return null;
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = findCategoryById(categoryId);
        if (category != null){
            categoryRepository.deleteById(categoryId);
            return "Category with ID [%s] deleted successfully".formatted(categoryId);
        }else {
            throw new ResourceNotFoundException("Category with id [%s] not found".formatted(categoryId));
        }
    }
    }

