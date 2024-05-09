package com.example.shoppingmall.product;

import com.example.shoppingmall.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
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
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findProducts(
            @RequestParam("limit") int limit,
            @RequestParam("currentPage") int currentPage,
            @RequestParam(value = "categoryId", required = false) int categoryId
    ) {
        log.info("limit = {}", limit);
        log.info("currentPage = {}", currentPage);
        log.info("categoryId = {}", categoryId);
        List<Product> products = productService.findAllProducts(limit, currentPage);
        return new ResponseEntity<>(products, HttpStatus.OK);
//        if (categoryId == null) {
//            List<Product> products = productService.findAllProducts(limit, currentPage);
//            int totalCount = productService.countAllProducts();
//
//            return new ResponseEntity<>(products, HttpStatus.OK);
//        } else {
//            List<Product> products = productService.findProductsByCategory(limit, currentPage, categoryId);
//            int totalCount = productService.countProductsByCategory(categoryId);
//
//
//        }
    }

    // 상품 개별 조회
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable(value = "id") int id) {
        // 1. Product 반환 필드 : id 추가해야 함
        // 2. id 숫자만 들어온 거 맞는지 유효성 검사 추가
        if (!Validator.isNumber(id)) {
            // TODO log INFO 레벨 id type 형태 확인
            log.info(id + " haha");
            log.trace("id {}", "haha");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Product resultProduct = productService.findProduct(id);

        if (resultProduct == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(resultProduct, HttpStatus.OK);
    }
}
