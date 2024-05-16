package com.example.shoppingmall.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    OrderRepository orderRepository;

    public void orderProducts(Order order) {
        orderRepository.saveOrder(order);
    }
}
