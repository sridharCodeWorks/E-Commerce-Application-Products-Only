package com.project.shoping.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shoping.dto.CategoryDto;
import com.project.shoping.entity.Category;
import com.project.shoping.entity.Product;
import com.project.shoping.repository.CategoryRepository;
import com.project.shoping.service.CategoryService;

import jakarta.validation.Valid;

@Service
public class CategoryServiceImplementaion implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category addNewCategory(Category category, @Valid CategoryDto categoryDto) {
		category.setCategoryName(categoryDto.getCategoryName());
		return categoryRepository.save(category);
	}

}
