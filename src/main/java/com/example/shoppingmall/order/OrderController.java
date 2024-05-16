package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import com.example.shoppingmall.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {
    OrderService orderService;
    ProductService productService;

    @PostMapping("/orders")
    public void orderProducts(@RequestBody OrderDTO orderDTO) {
        Product orderedProduct = productService.findProduct(orderDTO.getProductId());

        // TODO : 서비스로 이사 갈 코드 DTO -> Entity
        Order requestOrder = new Order(
                orderedProduct, orderDTO.getCount()
        );

        orderService.orderProducts(requestOrder);
    }
}
