package com.example.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopping.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can define custom query methods if needed
}