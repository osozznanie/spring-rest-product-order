package com.example.controller;

import com.example.payload.OrderDto;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // create order
    @PostMapping("/{id}")
    public ResponseEntity<Void> createOrder(@PathVariable(name = "id") Long productId, @RequestBody OrderDto orderDto) {
        orderService.createOrder(productId, orderDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

