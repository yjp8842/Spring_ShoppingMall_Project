package com.example.shoppingmall.product;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ProductService {
    ProductRepository productRepository;

    public Product registerProduct(Product product) {
        productRepository.save(product);

        return productRepository.findById(product.getId());
    }

    public Product findProduct(int id) {
        return productRepository.findById(id);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> findProductsByCategoryId(int limit, int currentPage, Integer categoryId) {
        PageRequest pageRequest = PageRequest.of(currentPage - 1, limit);
        return productRepository.findProductsByCategoryId(categoryId, pageRequest);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        productRepository.deleteByProductIds(productIds);
    }
}
