package com.example.shoppingmall.product;

import com.example.shoppingmall.utils.Validator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProductController {
//    @Autowired // DI
    ProductService productService;

    // 상품 개별 등록
    @PostMapping("/products")
    public ResponseEntity registerProduct(@RequestBody Product product) {
        if (Validator.isAlpha(product.getName()) && Validator.isNumber(product.getPrice())) {
            Product savedProduct = productService.registerProduct(product);

            try {
                System.out.println(savedProduct.getName());
            } catch (NullPointerException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
//            if (savedProduct == null)
//                return "상품 등록에 실패했습니다.";

            System.out.println(savedProduct.getName());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
