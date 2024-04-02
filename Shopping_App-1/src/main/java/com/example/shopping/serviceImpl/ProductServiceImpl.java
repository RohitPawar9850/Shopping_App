package com.example.shopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.entity.Product;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	  @Autowired
	    private ProductRepository productRepository; // Assuming you have a repository for Product

	    @Override
	    public Product getProductById(Long id) {
	        Optional<Product> productOptional = productRepository.findById(id);
	        return productOptional.orElse(null); // You can handle the case where product is not found
	    }

	    @Override
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    @Override
	    public boolean checkProductAvailability(Long productId, int quantity) {
	        // Retrieve the product from the database
	        Product product = productRepository.findById(productId)
	                .orElseThrow(() -> new RuntimeException("Product not found"));

	        // Check if the available quantity is greater than or equal to the desired quantity
	        return product.getAvailableQuantity() >= quantity;
	    }
}
