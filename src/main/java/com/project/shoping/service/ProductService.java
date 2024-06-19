package com.project.shoping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.shoping.dto.ProductDto;
import com.project.shoping.entity.Product;

import jakarta.validation.Valid;

@Service
public interface ProductService {

	public Product addNewProducts(@Valid ProductDto productDto, Product product);

	public List<Product> getAllProducts();

}
