package com.example.shopping.service;
import java.util.List;
import com.example.shopping.entity.Product;

public interface ProductService {
	Product getProductById(Long id);
    List<Product> getAllProducts();
    boolean checkProductAvailability(Long productId, int quantity);
}
