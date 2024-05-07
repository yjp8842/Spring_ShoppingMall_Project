package com.example.shoppingmall.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    String name;
    int price;
    String description;
    
    // setter는 가능한 도메인 객체에는 만들면 안됨
    // TODO setter는 DTO 등장하고, 지우러 오자!
}
