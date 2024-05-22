package com.example.shoppingmall.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(int id);
    
    // 모든 상품 조회
    List<Product> findProducts(int limit, int currentPage, Integer categoryId) {
        // limit, currentPage => 상품 id 범위
        // (currentPage - 1) * limit ~ (currentPage * limit) - 1 까지
        if (categoryId == null) {
            return productTable.values().stream().toList();
        } else {
            List<Product> resultProducts = new ArrayList<>();

            for (Product product : productTable.values()) {
                if (product.getCategoryId() == categoryId)
                    resultProducts.add(product);
            }

            return resultProducts;
        }
    }

    void deleteById(int id);

    void deleteByProductIds(List<Integer> productIds);
}
