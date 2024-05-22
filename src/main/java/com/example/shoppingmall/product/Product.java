package com.example.shoppingmall.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
    @Id
    private int id;
    private int productId;
    private int categoryId;
    private String name;
    private int price;
    private String description;

    public Product(int productId, int categoryId, String name, int price, String description) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
