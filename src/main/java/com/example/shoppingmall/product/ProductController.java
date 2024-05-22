package com.example.shoppingmall.product;

import com.example.shoppingmall.utils.ApiUtils;
import com.example.shoppingmall.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;

@RestController
@AllArgsConstructor
@Slf4j
public class ProductController {
//    @Autowired // DI
    ProductService productService;

    // 상품 개별 등록
    @PostMapping("/products")
    public ApiUtils.ApiResult registerProduct(@RequestBody Product product) {
        if (Validator.isAlpha(product.getName()) &&
                Validator.isNumber(product.getPrice())) {
            System.out.println("여기 !!!");
            log.info("product.getName() = {}", product.getName());

            Product savedProduct = productService.registerProduct(product);

            try {
                log.info("savedProduct.getName() = {}", savedProduct.getName());
            } catch (NullPointerException e) {
                return error("서버 에러", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return success(savedProduct.getCategoryId());
        } else {

            return error("잘못된 요청입니다.", HttpStatus.BAD_REQUEST);
        }
    }

    // 상품 전체, 카테고리별 조회
    @GetMapping("/products")
    public ApiUtils.ApiResult findProducts(
            @RequestParam("limit") int limit,
            @RequestParam("currentPage") int currentPage,
            @RequestParam(value = "categoryId", required = false) Integer categoryId
    ) {
        List<Product> products;

        if (categoryId == null) {
            products = productService.findAllProducts();
            if (products == null)
                return error("상품이 없습니다.", HttpStatus.BAD_REQUEST);
            
            return success(products);
        } else {
            products = productService.findProductsByCategoryId(limit, currentPage, categoryId);
            if (products == null)
                return error("해당 카테고리에 대한 상품이 없습니다.", HttpStatus.BAD_REQUEST);

            return success(products);
        }
    }

    // 상품 개별 조회
    @GetMapping("/products/{id}")
    public ApiUtils.ApiResult findProduct(@PathVariable(value = "id") int id) {
        // 1. Product 반환 필드 : id 추가해야 함
        // 2. id 숫자만 들어온 거 맞는지 유효성 검사 추가
        if (!Validator.isNumber(id)) {
            return error("id는 숫자여야 합니다.", HttpStatus.BAD_REQUEST);
        }

        Product resultProduct = productService.findProduct(id);

        if (resultProduct == null)
            return error("상품을 조회할 수 없습니다.", HttpStatus.NOT_FOUND);

        return success(resultProduct);
    }

    // 상품 1개 삭제
    @DeleteMapping("/products/{id}")
    public ApiUtils.ApiResult deleteProduct(@PathVariable(value = "id") int id) {
        if (!Validator.isNumber(id)) {
            return error("id는 숫자여야 합니다.", HttpStatus.BAD_REQUEST);
        }

        productService.deleteProduct(id);
        Product product = productService.findProduct(id);
        if (product == null)
            return success("상품이 삭제되었습니다.");
        else
            return error("상품이 삭제되지 않습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 상품 여러 개 삭제
    @PostMapping("/products/delete")
    public ApiUtils.ApiResult deleteProducts(@RequestBody Map<String, List<Integer>> deleteRequest) {
        List<Integer> productIds = deleteRequest.get("productIds");

        if (productIds.isEmpty()) {

            return error("상품 id가 비어있습니다.", HttpStatus.BAD_REQUEST);
        }

        productService.deleteProducts(productIds);
        return success("상품이 모두 삭제되었습니다.");
    }
}
