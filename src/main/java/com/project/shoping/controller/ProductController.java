package com.project.shoping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.shoping.dto.ProductDto;
import com.project.shoping.entity.Category;
import com.project.shoping.entity.Product;
import com.project.shoping.service.CategoryService;
import com.project.shoping.service.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping({ "", "/" })
	public String indexPageLoader(@RequestHeader(value = "Referer", required = false) String referer, Model model) {
		model.addAttribute("referer", referer);
		return "layouts/features/index";
	}

	@GetMapping("/addNewProduct")
	public String addNewProductPageLoader(@RequestHeader(value = "Referer", required = false) String referer,
			Model model, ProductDto productDto) {
		model.addAttribute("referer", referer);
		model.addAttribute("productDto", productDto);
		model.addAttribute("categories", categoryService.getAllCategories());
		return "layouts/features/addNewProduct";
	}

	@PostMapping("/addNewProduct")
	public String addNewProducts(@Valid @ModelAttribute(value = "productDto") ProductDto productDto,
			BindingResult bindingResult, @RequestHeader(value = "referer", required = false) String referer,
			Model model, Product product) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("referer", referer);
			model.addAttribute("categories", categoryService.getAllCategories());
			return "layouts/features/addNewProduct";
		} else {
			Product savedProducts = productService.addNewProducts(productDto, product);
			return "redirect:/product/";
		}
	}

	@GetMapping("/getAllProducts")
	public String getAllProducts(@RequestHeader(value = "Referer", required = false) String referer, Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "/layouts/behaviours/productsPage";
	}

}
