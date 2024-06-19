package com.project.shoping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.shoping.dto.CategoryDto;
import com.project.shoping.entity.Category;
import com.project.shoping.service.CategoryService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping({ "", "/" })
	public String loadCategoryIndexPage(Model model,
			@RequestHeader(value = "Referer", required = false) String referer) {
		model.addAttribute("referer", referer);
		return "layouts/features/categoryManagement";
	}

	@GetMapping("/addNewCategory")
	public String loadAddNewCategoryPage(Model model, CategoryDto categoryDto,
			@RequestHeader(value = "Referer", required = false) String referer) {
		model.addAttribute("referer", referer);
		model.addAttribute("categoryDto", categoryDto);
		return "layouts/features/addNewCategory";
	}

	@PostMapping("/addNewCategory")
	public String addNewCategory(Model model, @Valid @ModelAttribute(value = "categoryDto") CategoryDto categoryDto,
			BindingResult bindingResult, @RequestHeader(value = "Referer", required = false) String referer,
			Category category) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("referer", referer);
			model.addAttribute("categoryDto", categoryDto);
			return "layouts/features/addNewCategory";
		} else {
			Category newCategory = categoryService.addNewCategory(category, categoryDto);
			return "redirect:/product/addNewProduct";
		}
	}
}
