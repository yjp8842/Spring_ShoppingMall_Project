package com.example.shoppingmall.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Integer, Product> product_table = new HashMap<>();
    int id = 0; // DB auto_increment

    public Product save(Product product) {
        product.setId(id);
        product_table.put(id++, product);
        System.out.println("/products : repository - " + product_table.get(id - 1));
        return product_table.get(id);
    }

    public Product findProduct(int id) {
        return product_table.get(id);
    }
}
