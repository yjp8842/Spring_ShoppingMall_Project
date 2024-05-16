package com.example.shoppingmall.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private int categoryId;
    private String name;
    private int price;
    private String description;
}
