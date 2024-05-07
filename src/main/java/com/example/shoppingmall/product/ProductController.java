package com.example.shoppingmall.product;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.shoppingmall.utils.Validator.isAlpha;
import static com.example.shoppingmall.utils.Validator.isNumber;

@RestController
@AllArgsConstructor
public class ProductController {
//    @Autowired // DI
    ProductService productService;

    // 상품 개별 등록
    @PostMapping("/products")
    public void registerProduct(@RequestBody Product product) {
        // 유효성 검사 : name(영어), price(숫자)
        // 1) 조건문
        if (isAlpha(product.getName()))
            System.out.println("name은 알파벳!");
        if (isNumber(product.getPrice()))
            System.out.println("price는 숫자!");

        productService.registerProduct(product);
        System.out.println("/products : controller - " + product.getName());
    }

//    private boolean isNumber(Integer num) {
//        return Pattern.matches("^[0-9]*$", Integer.toString(num));
//    }
//
//    private boolean isAlpha(String str) {
//        return Pattern.matches("^[a-zA-Z]*$", str);
//    }

    // 상품 전체, 카테고리별 조회
    // 상품 개별 조회
}
