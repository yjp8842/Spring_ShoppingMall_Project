package com.example.shoppingmall.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private int id;

    @NotBlank(message = "상품 아이디는 필수 입력값입니다.")
    @JsonProperty("product_id")
    private int productId;

    @NotBlank(message = "카테고리 아이디는 필수 입력값입니다.")
    @JsonProperty("category_id")
    private int categoryId;

    @NotBlank(message = "이름은 필수 입력값입니다.")
    private String name;

    @NotBlank(message = "가격은 필수 입력값입니다.")
    private int price;

    @NotEmpty
    private String description;

    public Product convertToEntity() {
        return new Product(productId, categoryId, name, price, description);
    }
}
