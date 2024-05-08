package com.example.shoppingmall.product;

import com.example.shoppingmall.utils.Validator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProductController {
//    @Autowired // DI
    ProductService productService;

    // 상품 개별 등록
    @PostMapping("/products")
    public String registerProduct(@RequestBody Product product) {
        if (Validator.isAlpha(product.getName()) && Validator.isNumber(product.getPrice())) {
            Product savedProduct = productService.registerProduct(product);

            if (savedProduct == null)
                return "상품 등록에 실패했습니다.";

            System.out.println(savedProduct.getName());
            return "상품이 등록되었습니다.";
        } else
            return "name 또는 price가 형식에 맞지 않습니다.";
    }

    // 상품 전체, 카테고리별 조회

    // 상품 개별 조회
    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable int id) {
        // 1. Product 반환 필드 : id 추가해야 함
        // 2. id 숫자만 들어온 거 맞는지 유효성 검사 추가
        if (Validator.isNumber(id))
            return productService.findProduct(id);
        return null;
    }
}
