package com.example.shoppingmall.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Integer, Product> product_table = new HashMap<>();
    int id = 0;

    public void save(Product product) {
        product_table.put(id++, product);
        System.out.println("/products : repository - " + product_table.get(id - 1));
    }

    public void find() {

    }
}
