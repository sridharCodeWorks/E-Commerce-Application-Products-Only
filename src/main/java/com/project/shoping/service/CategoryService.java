package com.project.shoping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.shoping.dto.CategoryDto;
import com.project.shoping.entity.Category;
import com.project.shoping.entity.Product;

import jakarta.validation.Valid;

@Service
public interface CategoryService {

	public List<Category> getAllCategories();

	public Category addNewCategory(Category category, @Valid CategoryDto categoryDto);


}
