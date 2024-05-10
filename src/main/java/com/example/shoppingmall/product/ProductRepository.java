package com.example.shoppingmall.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Integer, Product> productTable = new HashMap<>();
    int id = 0; // DB auto_increment

    public Product save(Product product) {
        product.setId(id);
        productTable.put(id++, product);
        System.out.println("/products : repository - " + productTable.get(id - 1));
        return productTable.get(id - 1);
    }

    public Product findProduct(int id) {
        return productTable.get(id);
    }
    
    // 모든 상품 조회
    public List<Product> findProducts(int limit, int currentPage, Integer categoryId) {
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

    public void deleteProduct(int id) {
        productTable.remove(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        for (int id : productIds) {
            productTable.remove(id);
        }
    }
}
