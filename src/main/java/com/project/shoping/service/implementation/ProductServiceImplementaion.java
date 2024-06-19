package com.project.shoping.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shoping.dto.ProductDto;
import com.project.shoping.entity.Category;
import com.project.shoping.entity.Product;
import com.project.shoping.repository.ProductRepository;
import com.project.shoping.service.ProductService;

@Service
public class ProductServiceImplementaion implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addNewProducts(ProductDto productDto, Product product) {
		product.setProductName(productDto.getProductName());
		product.setProductPrice(product.getProductPrice());
		product.setProductCategory(product.getProductCategory());
		product.setProductStatus(product.getProductStatus());
		
		productDto.getProductCategory().getProducts().add(product);
		
		return productRepository.save(product);
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
}
