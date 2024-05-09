package com.example.shoppingmall.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    ProductRepository productRepository;

    public Product registerProduct(Product product) {
        System.out.println("/products : service - " + product);
        return productRepository.save(product);
    }

    public Product findProduct(int id) {
        return productRepository.findProduct(id);
    }

    public List<Product> findAllProducts(int limit, int currentPage) {
        return productRepository.findAllProducts(limit, currentPage);
    }
}
