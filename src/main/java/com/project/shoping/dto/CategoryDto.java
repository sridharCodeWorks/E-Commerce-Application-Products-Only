package com.project.shoping.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryDto {

	@NotBlank(message = "Category Name is Mandatory")
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
