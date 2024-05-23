package com.example.shoppingmall.product;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(int id);

    Product findByProductId(int productId);
    
//    // 카테고리별 상품 조회
    @Query("SELECT p FROM Product p WHERE (:categoryId IS NULL OR p.categoryId = :categoryId)")
    List<Product> findProductsByCategoryId(@Param("categoryId") Integer categoryId, Pageable pageable);

//    void deleteAllById(List<Integer> productIds);
}
