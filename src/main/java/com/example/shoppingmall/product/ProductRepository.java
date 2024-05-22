package com.example.shoppingmall.product;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(int id);
    
    // 카테고리별 상품 조회
    @Query("SELECT p FROM Product p WHERE (:categoryId IS NULL OR p.categoryId = :categoryId)")
    List<Product> findProductsByCategoryId(Integer categoryId, Pageable pageable);

    void deleteById(int id);

    void deleteByProductIds(List<Integer> productIds);
}
