package com.example.shoppingmall.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Integer, Product> product_table = new HashMap<>();
    int id = 0; // DB auto_increment

    public Product save(Product product) {
        product.setId(id);
        product_table.put(id++, product);
        System.out.println("/products : repository - " + product_table.get(id - 1));
        return product_table.get(id - 1);
    }

    public Product findProduct(int id) {
        return product_table.get(id);
    }

    public List<Product> findAllProducts(int limit, int currentPage) {
        // limit, currentPage => 상품 id 범위
        // (currentPage - 1) * limit ~ (currentPage * limit) - 1 까지
        return product_table.values().stream().toList();
    }
}
