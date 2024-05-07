package com.example.shoppingmall.product;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController {
//    @Autowired // DI
    ProductService productService;

    // 상품 개별 등록
    @PostMapping("/products")
    public void registerProduct(@RequestBody Product product) {
        productService.registerProduct(product);
        System.out.println("/products : controller - " + product.getName());
        
        // 유효성 검사 : name, price, description
        // 1) 조건문
        if (product.getName() == null || product.getDescription() == null) {
            System.out.println("데이터를 모두 입력해주세요!");
        }
    }

    // 상품 전체, 카테고리별 조회
    // 상품 개별 조회
}
