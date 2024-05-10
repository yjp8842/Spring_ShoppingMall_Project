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
        if (Validator.isAlpha(product.getName()) &&
                Validator.isNumber(product.getPrice())) {
            System.out.println("여기 !!!");
            log.info("product.getName() = {}", product.getName());

            Product savedProduct = productService.registerProduct(product);

            try {
                log.info("savedProduct.getName() = {}", savedProduct.getName());
            } catch (NullPointerException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
//            if (savedProduct == null)
//                return "상품 등록에 실패했습니다.";

//            log.info("savedProduct.getName() = {}", savedProduct.getName());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            System.out.println("배드 리퀘스트 !!!");
            System.out.println(Validator.isAlpha(product.getName()));
            System.out.println(Validator.isNumber(product.getPrice()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 상품 전체, 카테고리별 조회
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findProducts(
            @RequestParam("limit") int limit,
            @RequestParam("currentPage") int currentPage,
            @RequestParam(value = "categoryId", required = false) Integer categoryId
    ) {
        log.info("limit = {}", limit);
        log.info("currentPage = {}", currentPage);
        log.info("categoryId = {}", categoryId);

        List<Product> products;

        if (categoryId == null) {
            products = productService.findProducts(limit, currentPage, null);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            products = productService.findProducts(limit, currentPage, categoryId);
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
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

    // 상품 1개 삭제
    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable(value = "id") int id) {
        if (!Validator.isNumber(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        productService.deleteProduct(id);
        Product product = productService.findProduct(id);
        if (product == null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 상품 여러 개 삭제
    @PostMapping("/products/delete")
    public ResponseEntity deleteProducts(@RequestBody Map<String, List<Integer>> deleteRequest) {
        List<Integer> productIds = deleteRequest.get("productIds");

        if (productIds.isEmpty()) {
            log.info("productIds가 없음!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        productService.deleteProducts(productIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
