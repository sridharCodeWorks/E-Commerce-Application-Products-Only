package com.project.shoping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shoping.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
