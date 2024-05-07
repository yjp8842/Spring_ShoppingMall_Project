package com.example.shoppingmall.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    ProductRepository productRepository;

    public void registerProduct(Product product) {
        productRepository.save(product);
        System.out.println("/products : service - " + product);
    }
}
