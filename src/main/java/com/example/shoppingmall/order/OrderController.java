package com.example.shoppingmall.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
